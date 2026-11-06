import { a3 as A, bu as E } from "../shared/runtime.js";
function V(n, S) {
  let R = n;
  return n & (A.ARTIFACT.V | A.ASSEMBLE.V | A.MACHINE_PART.V) && (R = E.ARTIFACT.V), n & A.ENCLOSURE.V && (R = S || E.PRESSED_PLATE.V | E.SANDWICH_BOARD.V | E.TRUSS_FLOOR_PLATE.V | E.PRESSED_FLOOR_PLATE.V | E.FOLDING_PIECE.V), R;
}
export {
  V as c
};
