import { i as u, V as i } from "../shared/runtime.js";
function c(e, r, f = true) {
  if (!(e instanceof Array) || !(r instanceof Array) || e.length !== r.length) return false;
  if (f) for (let n = 0; n < e.length; n++) {
    if (typeof e[n] == "object") return l(e[n], r[n]);
    if (e[n] !== r[n]) return false;
  }
  else for (let n = 0; n < e.length; n++) {
    let s = false;
    for (let t = 0; t < r.length; t++) if (e[n] === r[t]) {
      s = true;
      break;
    }
    if (!s) return false;
  }
  return true;
}
function l(e, r) {
  e = i(e), r = i(r);
  var f = Object.getOwnPropertyNames(e), n = Object.getOwnPropertyNames(r);
  if (f.length !== n.length) return false;
  for (var s = 0; s < f.length; s++) {
    var t = f[s];
    if (t !== "__ob__" && e[t] !== r[t]) {
      if (typeof e[t] == "object") if (Array.isArray(e[t])) {
        if (!c(e[t], r[t])) return false;
      } else return l(e[t], r[t]);
      else if (e[t] || r[t]) return false;
    }
  }
  return true;
}
function g(e, r) {
  if (!u(e) && !u(r)) return true;
  if (!u(e) || !u(r)) return false;
  if (e.constructor === r.constructor) switch (e.constructor) {
    case Object:
      return l(e, r);
    case Array:
      return c(e, r);
    default:
      return e === r;
  }
  else return false;
}
export {
  g as j
};
