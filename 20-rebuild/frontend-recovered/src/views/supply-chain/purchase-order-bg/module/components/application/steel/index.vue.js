import { i as _, iX as B, D as V, vI as n, b as m } from "../../../../../../../shared/runtime.js";
import W from "./module/steel-plate-table.vue.js";
import R from "./module/section-steel-table.vue.js";
import N from "./module/steel-coil-table.vue.js";
import { inject as p } from "vue";
import { ref as S } from "vue";
import { watchEffect as O } from "vue";
import { reactive as g } from "vue";
import { watch as L } from "vue";
import { nextTick as E } from "vue";
import { computed as x } from "vue";
import { openBlock as $ } from "vue";
import { createBlock as A } from "vue";
import { mergeProps as D } from "vue";
import { resolveDynamicComponent as j } from "vue";
import { ElMessage as F } from "element-plus";
const z = { __name: "index", setup(U, { expose: d }) {
  var h;
  const s = (h = p("cu")) == null ? void 0 : h.form, f = p("matSpecRef"), o = S();
  O(() => {
    let t = 0, e = 0;
    ["steelPlateList", "sectionSteelList", "steelCoilList"].forEach((c) => {
      _(s[c]) && s[c].forEach((i) => {
        t += i.weighingTotalWeight || 0, e += Number(i.amount) || 0;
      });
    }), s.amount = B(e, V.YUAN), s.mete = t, s.meteUnit = "kg";
  });
  const a = g({ steelPlateList: null, sectionSteelList: null, steelCoilList: null }), w = (t) => {
    const e = { steelPlateList: null, sectionSteelList: null, steelCoilList: null }, l = { steelPlateList: null, sectionSteelList: null, steelCoilList: null };
    ["steelPlateList", "sectionSteelList", "steelCoilList"].forEach((i) => {
      _(t[i]) && (t[i] = t[i].map((r) => g(r)), e[i] = L(a, (r) => {
        r[i] && (l[i] = L(f, () => {
          t[i].forEach((u) => {
            var C;
            return (C = r[i]) == null ? void 0 : C.rowWatch(u);
          }), f.value && (f.value.initSelected(t[i].map((u) => ({ sn: u.sn, classifyId: u.classifyId }))), E(() => {
            l[i]();
          }));
        }, { immediate: true }), E(() => {
          e[i]();
        }));
      }, { immediate: true, deep: true }));
    });
  };
  L(() => s.currentBasicClass, (t) => {
    t && E(() => {
      var l;
      let e = "";
      switch (t) {
        case n.STEEL_PLATE.V:
          e = "steelPlateList";
          break;
        case n.SECTION_STEEL.V:
          e = "sectionSteelList";
          break;
        case n.STEEL_COIL.V:
          e = "steelCoilList";
          break;
      }
      a[e] || (a[e] = o.value), (l = s[e]) == null || l.forEach((c) => {
        var i;
        return (i = S[e]) == null ? void 0 : i.rowWatch(c);
      });
    });
  }, { immediate: true });
  const T = x(() => {
    switch (s.currentBasicClass) {
      case n.STEEL_PLATE.V:
        return W;
      case n.SECTION_STEEL.V:
        return R;
      case n.STEEL_COIL.V:
        return N;
      default:
        return null;
    }
  });
  function b(t) {
    var e;
    return (e = o.value) == null ? void 0 : e.rowInit(t);
  }
  function P() {
    if (m(s.steelPlateList) && m(s.sectionSteelList) && m(s.steelCoilList)) return F.warning("请填写数据"), false;
    const t = I();
    return t && (s.list = [...s.steelPlateList, ...s.sectionSteelList, ...s.steelCoilList], s.basicClass = s.currentBasicClass, s.list.forEach((e) => {
      s.basicClass = s.basicClass | e.basicClass, e.mete = e.weighingTotalWeight, e.weight = e.weighingTotalWeight;
    })), t;
  }
  function I() {
    return Object.keys(a).every((t) => a[t] ? a[t].validate() : true);
  }
  function v(t) {
    var e;
    (e = o.value) == null || e.rowWatch(t);
  }
  return d({ rowInit: b, validate: P, rowWatch: v, setFormCallback: w }), (t, e) => ($(), A(j(T.value), D({ ref_key: "steelRef", ref: o }, t.$attrs), null, 16));
} };
export {
  z as default
};
