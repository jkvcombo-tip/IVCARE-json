import kotlinx.serialization.Serializable

@Serializable
data class PlaceholderItem(val alertId: Int, val alertname: String, val emergency: String, val room: String) {
    val id = "Id(${alertId})"
    val alert = "Alert($alertname)"
    val content = "Content($emergency)"
    val details = "Details($room)"

    override fun toString(): String = "$id, $alert, $content, $details"
}