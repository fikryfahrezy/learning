import 'package:flutter/cupertino.dart';

import '../data/contact.dart';
import '../data/contact_group.dart';
import '../screens/contacts.dart';
import '../main.dart';

class ContactGroupsPage extends StatelessWidget {
  const ContactGroupsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return _ContactGroupsView(
      selectedListId: 0,
      onListSelected: (list) => Navigator.of(context).push(
        CupertinoPageRoute<void>(
          title: list.title,
          builder: (context) => ContactListsPage(listId: list.id),
        ),
      ),
    );
  }
}

class _ContactGroupsView extends StatelessWidget {
  const _ContactGroupsView({required this.selectedListId, required this.onListSelected});

  final int selectedListId;
  final void Function(ContactGroup) onListSelected;

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      backgroundColor: CupertinoColors.extraLightBackgroundGray,
      child: CustomScrollView(
        slivers: [
          const CupertinoSliverNavigationBar(largeTitle: Text('Lists')),
          SliverFillRemaining(
            child: ValueListenableBuilder<List<ContactGroup>>(
              valueListenable: contactGroupsModel.listNotifier,
              builder: (context, contactLists, child) {
                const groupIcon = Icon(
                  CupertinoIcons.group,
                  weight: 900,
                  size: 32,
                );

                const pairIcon = Icon(
                  CupertinoIcons.person_2,
                  weight: 900,
                  size: 24,
                );

                return CupertinoListSection.insetGrouped(
                  header: const Text('iPhone'),
                  children: [
                    for (final ContactGroup contactList in contactLists)
                      CupertinoListTile(
                        leading: contactList.id == 0 ? groupIcon : pairIcon,
                        title: Text(contactList.label),
                        trailing: _buildTrailing(contactList.contacts, context),
                        onTap: () => onListSelected(contactList),
                      ),
                  ],
                );
              },
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildTrailing(List<Contact> contacts, BuildContext context) {
   final TextStyle style = CupertinoTheme.of(
    context,
   ).textTheme.textStyle.copyWith(color: CupertinoColors.systemGrey);

   return Row(
    mainAxisSize: MainAxisSize.min,
    children: [
      Text(contacts.length.toString(), style: style),
      const Icon(
        CupertinoIcons.forward,
        color: CupertinoColors.systemGrey3,
        size: 18,
      ),
    ],
   );
  }
}


/// A sidebar component for selecting contact grouops on large screens.
class ContactGroupsSidebar extends StatelessWidget {
  const ContactGroupsSidebar({
    super.key,
    required this.selectedListId,
    required this.onListSelected,
  });

  final int selectedListId;
  final void Function(int) onListSelected;

  @override
  Widget build(BuildContext context) {
    return _ContactGroupsView(
      selectedListId: selectedListId,
      onListSelected: (list) => onListSelected(list.id),
    );
  }
}