import { i as _, iX as B, D as C, cP as l, b as m } from "../../../../../../../shared/runtime.js";
import I from "./module/auxiliary-material.vue.js";
import y from "./module/gas.vue.js";
import D from "./module/other.vue.js";
import { inject as v } from "vue";
import { ref as E } from "vue";
import { watchEffect as O } from "vue";
import { reactive as w } from "vue";
import { watch as L } from "vue";
import { nextTick as h } from "vue";
import { computed as P } from "vue";
import { openBlock as W } from "vue";
import { createBlock as $ } from "vue";
import { mergeProps as j } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { ElMessage as F } from "element-plus";
import "../../../../../../../modules/factory-select-b8d0a4ac.js";
const z = { __name: "index", setup(G, { expose: x }) {
  var d;
  const e = (d = v("cu")) == null ? void 0 : d.form, f = v("matSpecRef"), n = E();
  O(() => {
    let t = 0;
    ["auxiliaryMaterialList", "otherList", "gasList"].forEach((r) => {
      _(e[r]) && e[r].forEach((c) => {
        t += Number(c.amount) || 0;
      });
    }), e.amount = B(t, C.YUAN), e.mete = void 0, e.meteUnit = "";
  });
  const s = w({ auxiliaryMaterialList: null, otherList: null, gasList: null }), b = (t) => {
    const a = { auxiliaryMaterialList: null, otherList: null, gasList: null }, r = { auxiliaryMaterialList: null, otherList: null, gasList: null };
    ["auxiliaryMaterialList", "otherList", "gasList"].forEach((i) => {
      _(t[i]) && (t[i] = t[i].map((o) => w(o)), a[i] = L(s, (o) => {
        o[i] && (r[i] = L(f, () => {
          t[i].forEach((u) => {
            var g;
            return (g = o[i]) == null ? void 0 : g.rowWatch(u);
          }), f.value && (f.value.initSelected(t[i].map((u) => ({ sn: u.sn, classifyId: u.classifyId }))), h(() => {
            r[i]();
          }));
        }, { immediate: true }), h(() => {
          a[i]();
        }));
      }, { immediate: true, deep: true }));
    });
  };
  L(() => e.currentBasicClass, (t) => {
    t && h(() => {
      var r;
      let a = "";
      switch (t) {
        case l.MATERIAL.V:
          a = "auxiliaryMaterialList";
          break;
        case l.GAS.V:
          a = "gasList";
          break;
        case l.OTHER.V:
          a = "otherList";
          break;
      }
      s[a] || (s[a] = n.value), (r = e[a]) == null || r.forEach((c) => {
        var i;
        return (i = E[a]) == null ? void 0 : i.rowWatch(c);
      });
    });
  }, { immediate: true });
  const M = P(() => {
    switch (e.currentBasicClass) {
      case l.MATERIAL.V:
        return I;
      case l.GAS.V:
        return y;
      case l.OTHER.V:
        return D;
      default:
        return null;
    }
  });
  function R(t) {
    var a;
    return (a = n.value) == null ? void 0 : a.rowInit(t);
  }
  function p() {
    e.list = [...e.auxiliaryMaterialList, ...e.gasList, ...e.otherList], e.list.forEach((t) => {
    });
  }
  function T() {
    if (m(e.auxiliaryMaterialList) && m(e.gasList) && m(e.otherList)) return F.warning("请填写数据"), false;
    const t = V();
    return t && p(), t;
  }
  function V() {
    return Object.keys(s).every((t) => s[t] ? s[t].validate() : true);
  }
  function S() {
    return Object.keys(s).every((t) => s[t] ? s[t].TSValidate() : true);
  }
  function A(t) {
    var a;
    (a = n.value) == null || a.rowWatch(t);
  }
  return x({ rowInit: R, validate: T, rowWatch: A, setFormCallback: b, getData: p, TSValidateTable: S }), (t, a) => (W(), $(N(M.value), j({ ref_key: "steelRef", ref: n }, t.$attrs), null, 16));
} };
export {
  z as default
};
