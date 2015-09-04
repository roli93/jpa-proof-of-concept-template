package canchas;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.Collection;

public class ReservaBuilder {

  private LocalDateTime inicioReserva;
  private Collection<Jugador> jugadores;
  private Cancha cancha;

  public ReservaBuilder inicioReserva(LocalDateTime inicioReserva) {
    this.inicioReserva = inicioReserva;
    return this;
  }

  public ReservaBuilder jugadores(Collection<Jugador> jugadores) {
    this.jugadores = jugadores;
    return this;
  }

  private LocalDateTime finReserva() {
    return inicioReserva.plusHours(1);
  }

  public ReservaBuilder cancha(Cancha cancha) {
    this.cancha = cancha;
    return this;
  }

  public Reserva build() {
    return new Reserva(//
        jugadores.stream().map(jugador -> jugador.crearInscripcion()).collect(toList()), //
        inicioReserva, //
        finReserva(), //
        cancha.getColor());
  }

}
