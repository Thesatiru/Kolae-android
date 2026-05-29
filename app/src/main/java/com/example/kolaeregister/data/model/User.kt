package com.example.kolaeregister.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val email: String,
    val cnpj: String?,
    val birthdate: String?,
    val password: String,

    val role: String,
    val status: String ="Active",

    @ColumnInfo(name = "avatar_path")
    val avatarPath: String?,

    @ColumnInfo(name = "instagram_url")
    val instagramUrl: String? = null,

    @ColumnInfo(name = "facebook_url")
    val facebookUrl: String? = null,

    @ColumnInfo(name = "x_url")
    val xUrl: String? = null,

    @ColumnInfo(name = "force_password_change")
    val forcePasswordChange: Int = 0,

    @ColumnInfo(name = "email_verified_at")
    val emailVerifiedAt: String?,

    @ColumnInfo(name = "remember_token")
    val rememberToken: String?,

    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null,

    @ColumnInfo(name = "deleted_at")
    val deletedAt: String? = null

)
