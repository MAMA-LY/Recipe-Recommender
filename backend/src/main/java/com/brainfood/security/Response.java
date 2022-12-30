package com.brainfood.security;

public enum Response {

    PleaseSignIn,
    TokenVerified,
    InvalidToken,
    PasswordChanged,
    PasswordResetEmailSent,
    NoUserFoundByThisEmail,
    UsernameAlreadyExists,
    EmailAlreadyExists,
    UserCreated,
    AddedFavRecipe,
    RemovedFavRecipe,
    RecipeAlreadyFav,
    RecipeAlreadyNotAFav,
    CannotAddFavRecipe,
    CannotRemoveFavRecipe

}
