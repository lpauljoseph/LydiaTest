package fr.pjapps.lydiatest.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.flow.StateFlow


@Composable
fun ContactDetailsScreenNavigation(
    contactUUID: String?,
    onGoBack: () -> Unit,
    viewModel: ContactViewModel = hiltViewModel(),
) {
    viewModel.fetch(uuid = contactUUID)
    ContactDetailsScreen(onGoBack = onGoBack, viewModel.contactDetails)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ContactDetailsScreen(
    onGoBack: () -> Unit,
    contactDetails: StateFlow<Contact>
) {

    val contact = contactDetails.collectAsStateWithLifecycle()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = fullName(contact.value))
            },
            navigationIcon = {
                IconButton(onClick = onGoBack)
                {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
            },
        )
    }) { innerPaddings ->

        Row(modifier = Modifier.padding(innerPaddings)) {
            AsyncImage(
                model = contact.value.bigPicture,
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = contact.value.title)
                Text(text = contact.value.first)
                Text(text = contact.value.last)
                Text(text = contact.value.gender)
                Text(text = contact.value.phone)
                Text(text = contact.value.cell)
                Text(text = contact.value.uuid)
            }
        }
    }
}

private fun fullName(contact: Contact): String = "${contact.title} ${contact.first} ${contact.last}"