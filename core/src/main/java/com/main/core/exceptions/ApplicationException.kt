package com.main.core.exceptions

abstract class ApplicationException(message: String) : Exception(message)

class EmailException(message: String): ApplicationException(message)

class PasswordException(message: String): ApplicationException(message)

class ConfirmPasswordException(message: String): ApplicationException(message)

class UsernameException(message: String): ApplicationException(message)

class FirebaseException(message: String): ApplicationException(message)

class UndefinedException(message: String): ApplicationException(message)