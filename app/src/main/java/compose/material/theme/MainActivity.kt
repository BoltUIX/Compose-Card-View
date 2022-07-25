package compose.material.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.material.theme.ui.theme.Material3ComposeTheme

/*
* https://www.boltuix.com/2021/12/card_25.html
* */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3ComposeTheme {
                // A surface container using the 'background' color from the theme

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                // Gap between children = 26 dp
                    verticalArrangement = Arrangement.spacedBy(26.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {


                    // using custom design
                    CardSimple()
                    CardElevation()
                    CardBorder()



                    // using card material3 design
                    // * Card with content argument
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        content = {
                            Text("Card with content argument",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.labelLarge)
                        }
                    )

                    // * Card with shape argument
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        //set shape of the card
                        shape = RoundedCornerShape(16.dp),
                        content = {
                            Text("Card with shape argument", modifier = Modifier.padding(16.dp),style = MaterialTheme.typography.labelLarge)
                        }
                    )


                    // * Card with background color argument
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        //set background color of the card
                        colors = CardDefaults.cardColors(
                            containerColor =  MaterialTheme.colorScheme.primaryContainer,
                        ),
                        content = {
                            Text("Card with background color argument", modifier = Modifier.padding(16.dp),style = MaterialTheme.typography.labelLarge)
                        }
                    )


                    // * Card with elevation
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        //set card elevation of the card
                        elevation = CardDefaults.cardElevation(
                            defaultElevation =  10.dp,
                        ),
                        content = {
                            Text("Card with background color argument", modifier = Modifier.padding(16.dp),style = MaterialTheme.typography.labelLarge)
                        }
                    )

                    // * Card with border argument
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Black),
                        content = {
                            Text("Card with border argument", modifier = Modifier.padding(16.dp),style = MaterialTheme.typography.labelLarge)
                        }
                    )


                    Card(
                        //shape = MaterialTheme.shapes.medium,
                        shape = RoundedCornerShape(8.dp),
                        // modifier = modifier.size(280.dp, 240.dp)
                        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
                        //set card elevation of the card
                        elevation = CardDefaults.cardElevation(
                            defaultElevation =  10.dp,
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor =  MaterialTheme.colorScheme.primaryContainer,
                        ),
                    ) {
                        Column(modifier = Modifier.clickable(onClick = {  })) {

                            Image(
                                painter = painterResource(R.drawable.panda),
                                contentDescription = null, // decorative
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(150.dp)
                                    .fillMaxWidth()
                            )

                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "Title",
                                    style = MaterialTheme.typography.titleMedium,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Sub title Example code for android + composes app developers.",
                                    //maxLines = 1,
                                    //overflow = TextOverflow.Ellipsis,
                                    style = MaterialTheme.typography.titleSmall,
                                )
                            }
                        }
                    }



                }


            }
        }
    }
}


@Preview
@Composable
fun CardSimple() {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFD1D5E1)
                ) {
                    Text(
                        text = "New release",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Cute Cat toy",
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Price : 300$")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.panda),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun CardElevation() {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFD1D5E1)
                ) {
                    Text(
                        text = "New release",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Cute Cat toy",
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Price : 300$")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.panda),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun CardBorder() {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFD1D5E1)
                ) {
                    Text(
                        text = "New release",
                        fontSize =  12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Cute Cat toy",
                    fontSize =  24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Price : 300$")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        tint = Color(0xFFF6B266),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.panda),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}

