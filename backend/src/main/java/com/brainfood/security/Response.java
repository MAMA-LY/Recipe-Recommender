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
    MissingInputs,
    UserCreated,
    AddedFavRecipe,
    RemovedFavRecipe,
    RecipeAlreadyFav,
    RecipeAlreadyNotAFav,
    CannotAddFavRecipe,
    CannotRemoveFavRecipe

}
