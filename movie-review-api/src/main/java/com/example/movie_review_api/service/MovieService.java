package com.example.movie_review_api.service;

import com.example.movie_review_api.model.Movie;
import com.example.movie_review_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Criar ou atualizar um filme
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Listar todos os filmes
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Obter um filme por ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Atualizar um filme existente
    public Optional<Movie> updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitulo(movieDetails.getTitulo());
            movie.setGenero(movieDetails.getGenero());
            movie.setRating(movieDetails.getRating());
            return Optional.of(movieRepository.save(movie));
        }
        return Optional.empty();
    }

    // Deletar um filme
    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Avaliar um filme
    public Optional<Movie> rateMovie(Long id, double rating) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setRating(rating);
            return Optional.of(movieRepository.save(movie));
        }
        return Optional.empty();
    }

    // Encontrar um filme não avaliado
    public Optional<Movie> findUnratedMovie() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getRating() == null)
                .findFirst();
    }
}
