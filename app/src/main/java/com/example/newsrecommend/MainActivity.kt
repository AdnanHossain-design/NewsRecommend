package com.example.newsrecommend

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsrecommend.ui.theme.NewsRecommendTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsRecommendTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    fetchArticles(context = this, category = "technology")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

private fun fetchArticles(context: Context, category: String) {
    val apiKey = "6b3af7a931ccfe2e29046edd71eda1de"

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetroFitInstance.api.getArticle(apiKey, category)
            withContext(Dispatchers.Main) {
                response?.let {
                    Toast.makeText(context, "Articles fetched successfully", Toast.LENGTH_SHORT).show()
                } ?: run {
                    Toast.makeText(context, "No articles available", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Error fetching articles: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
