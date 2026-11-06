import { i as l, b as E, cM as u, d as R } from "../shared/runtime.js";
import { reactive as y } from "vue";
import { watch as S } from "vue";
import { onBeforeUnmount as _ } from "vue";
import { provide as I } from "vue";
import * as v from "lodash";
const f = {};
f.KEY_PREFIX = "ADD_FORM";
f.TYPE = { normal: 1, browserClose: 2 };
function k(e, t, o, { useDraftCallback: r, clearDraftCallback: s } = {}) {
  const n = y({ key: e, expired: 6048e5, form: t, initForm: void 0, init: void 0, isRegister: false, saveStoreForm: () => m(n), resetForm: () => {
    F(n), n.form.length = 0, n.init && n.init(), typeof s == "function" && s();
  } });
  if (l(o)) {
    let i;
    switch (o.constructor.name) {
      case "Function":
      case "RefImpl":
      case "EL":
      case "ComputedRefImpl":
        i = o;
        break;
      default:
        i = o;
    }
    S(i, (p) => {
      p ? a(n, r) : c(n);
    });
  } else a(n, r);
  return _(() => {
    d(n, o), c(n);
  }), window.onbeforeunload = () => {
    d(n, o);
  }, I("nfmStore", n), { ADD_FORM: n, openStore: (i) => {
    i && (n.form = i), a(n, r);
  }, closeStore: () => c(n), saveStoreForm: (i) => m(n, i), clearFormStorage: () => F(n) };
}
function w(e) {
  e.initForm = void 0;
}
function a(e, t) {
  const o = Y(e.key);
  if (E(o)) e.init && e.init();
  else {
    const r = o.content;
    P(e.form, r), typeof t == "function" && t(e.form);
  }
  e.initForm = v.cloneDeep(e.form), e.isRegister = true;
}
function c(e) {
  e.isRegister = false, w(e);
}
function P(e, t) {
  for (const o in e) e[o] = void 0;
  for (const o in t) e[o] = t[o];
}
function m(e, t, o = f.TYPE.normal) {
  if (!e.isRegister) return false;
  const r = t || e.form;
  try {
    return u.set(`${f.KEY_PREFIX}_${e.key}`, { type: o, content: r }, e.expired), true;
  } catch (s) {
    return console.log("缓存错误信息", s), console.log("缓存", r), false;
  }
}
function F(e) {
  u.remove(`${f.KEY_PREFIX}_${e.key}`);
}
function d(e, t) {
  if (!e.isRegister) return;
  let o = true;
  l(t) && (o = typeof t == "function" ? t() : t.value), console.log(e.initForm, e.form, "abnormalClose"), o && !R(e.initForm, e.form) && m(e, null, f.TYPE.browserClose);
}
function Y(e) {
  return u.get(`${f.KEY_PREFIX}_${e}`);
}
export {
  k as u
};
