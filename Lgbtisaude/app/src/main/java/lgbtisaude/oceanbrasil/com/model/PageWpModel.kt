package lgbtisaude.oceanbrasil.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Classe referente as paginas do wordpress
 *
 * Essa classe foi gerada apartir do json retornado do wordpress
 * usei o site http://www.jsonschema2pojo.org/
 * para converter de json pra java e depois converti para kotlin
 */
class PageWpModel {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("date_gmt")
    @Expose
    var dateGmt: String? = null
    @SerializedName("guid")
    @Expose
    var guid: Guid? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("modified_gmt")
    @Expose
    var modifiedGmt: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("title")
    @Expose
    var title: Title? = null
    @SerializedName("content")
    @Expose
    var content: Content? = null
    @SerializedName("excerpt")
    @Expose
    var excerpt: Excerpt? = null
    @SerializedName("author")
    @Expose
    var author: Int? = null
    @SerializedName("featured_media")
    @Expose
    var featuredMedia: Int? = null
    @SerializedName("parent")
    @Expose
    var parent: Int? = null
    @SerializedName("menu_order")
    @Expose
    var menuOrder: Int? = null
    @SerializedName("comment_status")
    @Expose
    var commentStatus: String? = null
    @SerializedName("ping_status")
    @Expose
    var pingStatus: String? = null
    @SerializedName("template")
    @Expose
    var template: String? = null
    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null
    @SerializedName("better_featured_image")
    @Expose
    var betterFeaturedImage: Any? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

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
        @SerializedName("wp:attachment")
        @Expose
        var wpAttachment: List<WpAttachment>? = null
        @SerializedName("curies")
        @Expose
        var curies: List<Cury>? = null

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

    inner class Title {

        @SerializedName("rendered")
        @Expose
        var rendered: String? = null

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

}


