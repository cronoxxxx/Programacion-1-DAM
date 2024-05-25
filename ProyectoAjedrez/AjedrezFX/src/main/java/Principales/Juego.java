package Principales;

import Modelo.*;


public class Juego {
    private int Turno = 0;

    public String getTurno() {
        return (Turno % 2 == 0) ? "B" : "N";
    }

    public Juego() {
        this.Turno = 0;
    }

    public void setTurno() {
        this.Turno = Turno + 1;
    }

    public String validadMovimientoFx(Posicion posoriginal, Posicion posfinal, Tablero tablero, Juego juego) {
        Movimiento movimiento = new Movimiento(posoriginal, posfinal);
        //boolean jugadaa = false;
        String valido = null;
        if (tablero.hayPieza(posoriginal.getFila(), posoriginal.getColumna())) {
            if (tablero.devuelvePieza(posoriginal).validoMovimiento(movimiento, tablero, juego)) {
                if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("blanco") && juego.getTurno().equals("B")) {
                    if (tablero.jaqueBlanco(juego)) {
                        if (tablero.evitaJaque(movimiento, juego)) {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        //jugadaa = true;
                                    } else {
                                        //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                    }
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            }
                        } else {
                            //label2.setText(Constantes.DEBES_EVITAR_EL_JAQUE);
                            valido="DEBES_EVITAR_EL_JAQUE";
                        }
                    } else {
                        if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                            if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                            }
                        } else {
                            if (!tablero.provocaJaque(movimiento, juego)) {
                                //jugadaa = true;
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                            }
                        }
                    }
                } else if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("negro") && juego.getTurno().equals("N")) {
                    if (tablero.jaqueNegro(juego)) {
                        if (tablero.evitaJaque(movimiento, juego)) {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        //jugadaa = true;
                                    } else {
                                        //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                    }
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            }
                        } else {
                            //label2.setText(Constantes.DEBES_EVITAR_EL_JAQUE);
                            valido="DEBES_EVITAR_EL_JAQUE";
                        }
                    } else {
                        if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                            if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                            }
                        } else {
                            if (!tablero.provocaJaque(movimiento, juego)) {
                                //jugadaa = true;
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                            }
                        }
                    }
                } else {
                    //label2.setText(Constantes.NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA);
                    valido="NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA";
                }
            } else {
                //label2.setText(Constantes.EL_MOVIMIENTO_INTRODUCIDO_NO_ES_VÁLIDO);
                valido="EL_MOVIMIENTO_INTRODUCIDO_NO_ES_VÁLIDO";
            }
        } else {
            //label2.setText(Constantes.NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA);
            valido="NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA";
        }
        return valido;
    }

    public boolean validadMovimiento(Tablero tablero, Posicion posoriginal, Posicion posfinal, Juego juego) {
        Movimiento movimiento = new Movimiento(posoriginal, posfinal);
        boolean jugadaa = false;
        if (posoriginal.getFila() >= 0 && posoriginal.getFila() <= 7 && posoriginal.getColumna() >= 0 && posoriginal.getColumna() <= 7 && posfinal.getFila() >= 0 && posfinal.getFila() <= 7 && posfinal.getColumna() >= 0 && posfinal.getColumna() <= 7) //valida dentro del rango
            if (tablero.hayPieza(posoriginal.getFila(), posoriginal.getColumna())) { //halla si hay pieza en esas posiciones
                if (tablero.devuelvePieza(posoriginal).validoMovimiento(movimiento, tablero, juego)) { //si la pieza que da concuerda con los movimientos validos implementados en sus propias clases
                    if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("blanco") && getTurno().equals("B")) { //si es blanco y esta en su turno
                        if (tablero.jaqueBlanco(juego)) { //si hay jaque
                            if (tablero.evitaJaque(movimiento,juego)) { //si se evita
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) { //si hay una pieza en la posicion final
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) { //si es del equipo contrario, o se puede realizar un enroque
                                        if (!tablero.provocaJaque(movimiento,juego)) { //y si esa jugada no provoca un jaque, se valida
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) { //si la posicion final, moverse alla no provoca jaque
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else { //si no hay jaque
                            //copypaste
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento,juego)) {
                                    jugadaa = true;
                                }
                            }
                        }
                    } else if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("negro") && getTurno().equals("N")) { //para las negras, y lo mismo de arriba
                        if (tablero.jaqueNegro(juego)) {
                            if (tablero.evitaJaque(movimiento,juego)) {
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento,juego)) {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento,juego)) {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento,juego)) {
                                    jugadaa = true;
                                }
                            }
                        }
                    }
                }
            }
        return jugadaa;
    }
}
