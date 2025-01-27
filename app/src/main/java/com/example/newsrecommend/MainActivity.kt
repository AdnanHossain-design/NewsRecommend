package com.example.newsrecommend


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchArticles("sports")


    }



    private fun fetchArticles(category: String) {
        val apiKey = "6817df3764dd87a774762ed5026d24df"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetroFitInstance.api.getArticle(apiKey, category)

                // Ensure you have enough articles to display
                val articles = response.data.take(8) // Get the first 7 articles (or adjust as needed)

                withContext(Dispatchers.Main) {
                    // Reference your TextViews
                    val textViews = listOf(
                        findViewById<TextView>(R.id.link1),
                        findViewById<TextView>(R.id.link2),
                        findViewById<TextView>(R.id.link3),
                        findViewById<TextView>(R.id.link4),
                        findViewById<TextView>(R.id.link5),
                        findViewById<TextView>(R.id.link6),
                        findViewById<TextView>(R.id.link7),
                        findViewById<TextView>(R.id.link8)
                    )

                    articles.forEachIndexed { index, article ->
                        val title = article.title ?: "No Title"
                        val url = article.url ?: "#"

                        // Update the TextView text and set a click listener for each
                        textViews[index].apply {
                            text = title
                            setOnClickListener {
                                openLink(url)
                            }
                        }
                    }

                    // Notify if fewer articles were retrieved

                        Toast.makeText(
                            this@MainActivity,
                            "Fetched ${articles.size} articles.",
                            Toast.LENGTH_SHORT
                        ).show()

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}