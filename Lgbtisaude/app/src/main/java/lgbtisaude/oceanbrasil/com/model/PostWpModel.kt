package lgbtisaude.oceanbrasil.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *
 * Classe referente aos posts do wordpress
 *
 * Essa classe foi gerada apartir do json retornado do wordpress
 * usei o site http://www.jsonschema2pojo.org/
 * para converter de json pra java e depois converti para kotlin
 */

class PostWpModel {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("date")
    @Expose
    private var date: String? = null
    @SerializedName("date_gmt")
    @Expose
    private var dateGmt: String? = null
    @SerializedName("guid")
    @Expose
    private var guid: Guid? = null
    @SerializedName("modified")
    @Expose
    private var modified: String? = null
    @SerializedName("modified_gmt")
    @Expose
    private var modifiedGmt: String? = null
    @SerializedName("slug")
    @Expose
    private var slug: String? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("link")
    @Expose
    private var link: String? = null
    @SerializedName("title")
    @Expose
    private var title: Title? = null
    @SerializedName("content")
    @Expose
    private var content: Content? = null
    @SerializedName("excerpt")
    @Expose
    private var excerpt: Excerpt? = null
    @SerializedName("author")
    @Expose
    private var author: Int? = null
    @SerializedName("featured_media")
    @Expose
    private var featuredMedia: Int? = null
    @SerializedName("comment_status")
    @Expose
    private var commentStatus: String? = null
    @SerializedName("ping_status")
    @Expose
    private var pingStatus: String? = null
    @SerializedName("sticky")
    @Expose
    private var sticky: Boolean? = null
    @SerializedName("template")
    @Expose
    private var template: String? = null
    @SerializedName("format")
    @Expose
    private var format: String? = null
    @SerializedName("meta")
    @Expose
    private var meta: List<Any>? = null
    @SerializedName("categories")
    @Expose
    private var categories: List<Int>? = null
    @SerializedName("tags")
    @Expose
    private var tags: List<Any>? = null
    @SerializedName("better_featured_image")
    @Expose
    private var betterFeaturedImage: BetterFeaturedImage? = null
    @SerializedName("_links")
    @Expose
    private var links: Links? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun getDateGmt(): String? {
        return dateGmt
    }

    fun setDateGmt(dateGmt: String) {
        this.dateGmt = dateGmt
    }

    fun getGuid(): Guid? {
        return guid
    }

    fun setGuid(guid: Guid) {
        this.guid = guid
    }

    fun getModified(): String? {
        return modified
    }

    fun setModified(modified: String) {
        this.modified = modified
    }

    fun getModifiedGmt(): String? {
        return modifiedGmt
    }

    fun setModifiedGmt(modifiedGmt: String) {
        this.modifiedGmt = modifiedGmt
    }

    fun getSlug(): String? {
        return slug
    }

    fun setSlug(slug: String) {
        this.slug = slug
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getLink(): String? {
        return link
    }

    fun setLink(link: String) {
        this.link = link
    }

    fun getTitle(): Title? {
        return title
    }

    fun setTitle(title: Title) {
        this.title = title
    }

    fun getContent(): Content? {
        return content
    }

    fun setContent(content: Content) {
        this.content = content
    }

    fun getExcerpt(): Excerpt? {
        return excerpt
    }

    fun setExcerpt(excerpt: Excerpt) {
        this.excerpt = excerpt
    }

    fun getAuthor(): Int? {
        return author
    }

    fun setAuthor(author: Int?) {
        this.author = author
    }

    fun getFeaturedMedia(): Int? {
        return featuredMedia
    }

    fun setFeaturedMedia(featuredMedia: Int?) {
        this.featuredMedia = featuredMedia
    }

    fun getCommentStatus(): String? {
        return commentStatus
    }

    fun setCommentStatus(commentStatus: String) {
        this.commentStatus = commentStatus
    }

    fun getPingStatus(): String? {
        return pingStatus
    }

    fun setPingStatus(pingStatus: String) {
        this.pingStatus = pingStatus
    }

    fun getSticky(): Boolean? {
        return sticky
    }

    fun setSticky(sticky: Boolean?) {
        this.sticky = sticky
    }

    fun getTemplate(): String? {
        return template
    }

    fun setTemplate(template: String) {
        this.template = template
    }

    fun getFormat(): String? {
        return format
    }

    fun setFormat(format: String) {
        this.format = format
    }

    fun getMeta(): List<Any>? {
        return meta
    }

    fun setMeta(meta: List<Any>) {
        this.meta = meta
    }

    fun getCategories(): List<Int>? {
        return categories
    }

    fun setCategories(categories: List<Int>) {
        this.categories = categories
    }

    fun getTags(): List<Any>? {
        return tags
    }

    fun setTags(tags: List<Any>) {
        this.tags = tags
    }

    fun getBetterFeaturedImage(): BetterFeaturedImage? {
        return betterFeaturedImage
    }

    fun setBetterFeaturedImage(betterFeaturedImage: BetterFeaturedImage) {
        this.betterFeaturedImage = betterFeaturedImage
    }

    fun getLinks(): Links? {
        return links
    }

    fun setLinks(links: Links) {
        this.links = links
    }

    inner class About {

        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class Author {

        @SerializedName("embeddable")
        @Expose
        var embeddable: Boolean? = null
        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class BetterFeaturedImage {

        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("alt_text")
        @Expose
        var altText: String? = null
        @SerializedName("caption")
        @Expose
        var caption: String? = null
        @SerializedName("description")
        @Expose
        var description: String? = null
        @SerializedName("media_type")
        @Expose
        var mediaType: String? = null
        @SerializedName("media_details")
        @Expose
        var mediaDetails: MediaDetails? = null
        @SerializedName("post")
        @Expose
        var post: Int? = null
        @SerializedName("source_url")
        @Expose
        var sourceUrl: String? = null

    }

    inner class Collection {

        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class Content {

        @SerializedName("rendered")
        @Expose
        var rendered: String? = null
        @SerializedName("protected")
        @Expose
        var protected: Boolean? = null

    }

    inner class Cury {

        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("href")
        @Expose
        var href: String? = null
        @SerializedName("templated")
        @Expose
        var templated: Boolean? = null

    }

    inner class Excerpt {

        @SerializedName("rendered")
        @Expose
        var rendered: String? = null
        @SerializedName("protected")
        @Expose
        var protected: Boolean? = null

    }

    inner class Guid {

        @SerializedName("rendered")
        @Expose
        var rendered: String? = null

    }

    inner class ImageMeta {

        @SerializedName("aperture")
        @Expose
        var aperture: String? = null
        @SerializedName("credit")
        @Expose
        var credit: String? = null
        @SerializedName("camera")
        @Expose
        var camera: String? = null
        @SerializedName("caption")
        @Expose
        var caption: String? = null
        @SerializedName("created_timestamp")
        @Expose
        var createdTimestamp: String? = null
        @SerializedName("copyright")
        @Expose
        var copyright: String? = null
        @SerializedName("focal_length")
        @Expose
        var focalLength: String? = null
        @SerializedName("iso")
        @Expose
        var iso: String? = null
        @SerializedName("shutter_speed")
        @Expose
        var shutterSpeed: String? = null
        @SerializedName("title")
        @Expose
        var title: String? = null
        @SerializedName("orientation")
        @Expose
        var orientation: String? = null
        @SerializedName("keywords")
        @Expose
        var keywords: List<Any>? = null

    }

    inner class Links {

        @SerializedName("self")
        @Expose
        var self: List<Self>? = null
        @SerializedName("collection")
        @Expose
        var collection: List<Collection>? = null
        @SerializedName("about")
        @Expose
        var about: List<About>? = null
        @SerializedName("author")
        @Expose
        var author: List<Author>? = null
        @SerializedName("replies")
        @Expose
        var replies: List<Reply>? = null
        @SerializedName("version-history")
        @Expose
        var versionHistory: List<VersionHistory>? = null
        @SerializedName("wp:featuredmedia")
        @Expose
        var wpFeaturedmedia: List<WpFeaturedmedium>? = null
        @SerializedName("wp:attachment")
        @Expose
        var wpAttachment: List<WpAttachment>? = null
        @SerializedName("wp:term")
        @Expose
        var wpTerm: List<WpTerm>? = null
        @SerializedName("curies")
        @Expose
        var curies: List<Cury>? = null

    }

    inner class MediaDetails {

        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
        @SerializedName("file")
        @Expose
        var file: String? = null
        @SerializedName("sizes")
        @Expose
        var sizes: Sizes? = null
        @SerializedName("image_meta")
        @Expose
        var imageMeta: ImageMeta? = null

    }

    inner class Medium {

        @SerializedName("file")
        @Expose
        var file: String? = null
        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
        @SerializedName("mime-type")
        @Expose
        var mimeType: String? = null
        @SerializedName("source_url")
        @Expose
        var sourceUrl: String? = null

    }

    inner class MediumLarge {

        @SerializedName("file")
        @Expose
        var file: String? = null
        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
        @SerializedName("mime-type")
        @Expose
        var mimeType: String? = null
        @SerializedName("source_url")
        @Expose
        var sourceUrl: String? = null

    }

    inner class Reply {

        @SerializedName("embeddable")
        @Expose
        var embeddable: Boolean? = null
        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class Self {

        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class Sizes {

        @SerializedName("thumbnail")
        @Expose
        var thumbnail: Thumbnail? = null
        @SerializedName("medium")
        @Expose
        var medium: Medium? = null
        @SerializedName("medium_large")
        @Expose
        var mediumLarge: MediumLarge? = null
        @SerializedName("twentyseventeen-thumbnail-avatar")
        @Expose
        var twentyseventeenThumbnailAvatar: TwentyseventeenThumbnailAvatar? = null

    }

    inner class Thumbnail {

        @SerializedName("file")
        @Expose
        var file: String? = null
        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
        @SerializedName("mime-type")
        @Expose
        var mimeType: String? = null
        @SerializedName("source_url")
        @Expose
        var sourceUrl: String? = null

    }

    inner class Title {

        @SerializedName("rendered")
        @Expose
        var rendered: String? = null

    }

    inner class TwentyseventeenThumbnailAvatar {

        @SerializedName("file")
        @Expose
        var file: String? = null
        @SerializedName("width")
        @Expose
        var width: Int? = null
        @SerializedName("height")
        @Expose
        var height: Int? = null
        @SerializedName("mime-type")
        @Expose
        var mimeType: String? = null
        @SerializedName("source_url")
        @Expose
        var sourceUrl: String? = null

    }

    inner class VersionHistory {

        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class WpAttachment {

        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class WpFeaturedmedium {

        @SerializedName("embeddable")
        @Expose
        var embeddable: Boolean? = null
        @SerializedName("href")
        @Expose
        var href: String? = null

    }

    inner class WpTerm {

        @SerializedName("taxonomy")
        @Expose
        var taxonomy: String? = null
        @SerializedName("embeddable")
        @Expose
        var embeddable: Boolean? = null
        @SerializedName("href")
        @Expose
        var href: String? = null

    }
}