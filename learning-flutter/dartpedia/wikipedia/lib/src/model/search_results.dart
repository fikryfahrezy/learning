class SearchResult {
  SearchResult({required this.title, required this.url});

  final String title;
  final String url;
}

class SearchResults {
  SearchResults({required this.results, this.searchTerm});

  final List<SearchResult> results;
  final String? searchTerm;

  static SearchResults fromJson(List<Object?> json) {
    final List<SearchResult> results = <SearchResult>[];
    if (json case [
      String searchTerm,
      Iterable articleTitles,
      Iterable _,
      Iterable urls,
    ]) {
      final List titlesList = articleTitles.toList();
      final List urlsList = urls.toList();
      for (int i = 0; i < titlesList.length; i++) {
        results.add(SearchResult(title: titlesList[i], url: urlsList[i]));
      }
      return SearchResults(results: results, searchTerm: searchTerm);
    }

    throw FormatException('Could not deserialize SearchResults, json=$json');
  }

  @override
  String toString() {
    final StringBuffer pretty = StringBuffer();
    for (final SearchResult result in results) {
      pretty.writeln('${result.url} \n');
    }

    return '\nSearchResults for $searchTerm: \n$pretty';
  }
}