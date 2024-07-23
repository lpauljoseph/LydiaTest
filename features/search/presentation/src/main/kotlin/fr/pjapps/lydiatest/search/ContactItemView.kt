package fr.pjapps.lydiatest.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author Loïc PAUL-JOSEPH
 */

@Composable
fun ContactItemView(
    contact: SearchContactUiState,
    onItemClick: (Long) -> Unit = {}
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(contact.id) }
        .padding(10.dp)) {
        Text(text = contact.title)
        Text(text = contact.firstName)
        Text(text = contact.lastName)
        Text(text = contact.gender)
        Text(text = contact.phone)
        Text(text = contact.cell)
    }
}
