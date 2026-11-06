import { V as u, aI as p } from "../shared/runtime.js";
function l(t = {}, a = 1, n) {
  const c = (o) => {
    o.length = 0;
    for (let e = 0; e < a; e++) r(o);
  }, r = (o) => {
    const e = u(t);
    e.uid = p(), n && o.length > 0 && n.forEach((s, i) => {
      e[i] = s;
    }), o.push(e);
  };
  return { init: c, addRow: r, removeRow: (o, e) => {
    o.splice(e, 1);
  } };
}
export {
  l as u
};
