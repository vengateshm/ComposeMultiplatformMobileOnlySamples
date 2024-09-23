package dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class EmailClient {
    fun open(
        title:String,
        body:String,
        onComplete:(Boolean) -> Unit
    )
}