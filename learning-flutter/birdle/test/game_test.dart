import 'package:birdle/game.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  group('Game.guess', () {
    test('records a valid guess', () {
      final game = Game(seed: 0);

      final result = game.guess('aback');

      expect(game.guesses.first, result);
      expect(game.previousGuess.toString(), 'aback');
      expect(game.didWin, isTrue);
    });

    test('rejects guesses shorter than five letters', () {
      final game = Game(seed: 0);

      expect(
        () => game.guess('bird'),
        throwsA(
          isA<ArgumentError>().having(
            (error) => error.message.toString(),
            'message',
            contains('exactly 5 letters'),
          ),
        ),
      );
    });

    test('rejects guesses outside the current word list', () {
      final game = Game(seed: 0);

      expect(
        () => game.guess('apple'),
        throwsA(
          isA<ArgumentError>().having(
            (error) => error.message.toString(),
            'message',
            contains('current word list'),
          ),
        ),
      );
    });
  });

  group('Game.isLegalGuess', () {
    test('normalizes case and whitespace before checking the word list', () {
      final game = Game(seed: 0);

      expect(game.isLegalGuess('  ABACK '), isTrue);
      expect(game.isLegalGuess(' APPLE '), isFalse);
    });
  });
}
