import { i as g, iX as O, D as x, sl as c, b as L } from "../../../../../../../shared/runtime.js";
import B from "./module/steel-plate-table.vue.js";
import $ from "./module/section-steel-table.vue.js";
import v from "./module/steel-coil-table.vue.js";
import A from "./module/other-steel-material-table.vue.js";
import { inject as T } from "vue";
import { ref as p } from "vue";
import { watchEffect as N } from "vue";
import { reactive as d } from "vue";
import { watch as h } from "vue";
import { nextTick as S } from "vue";
import { computed as D } from "vue";
import { openBlock as j } from "vue";
import { createBlock as F } from "vue";
import { mergeProps as U } from "vue";
import { resolveDynamicComponent as k } from "vue";
import { ElMessage as C } from "element-plus";
import "../../../../../../../modules/factory-select-b8d0a4ac.js";
const Q = { __name: "index", setup(H, { expose: w }) {
  var _;
  const s = (_ = T("cu")) == null ? void 0 : _.form, m = T("matSpecRef"), u = p();
  N(() => {
    let e = 0, t = 0;
    ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"].forEach((r) => {
      g(s[r]) && s[r].forEach((i) => {
        e += (r === "otherSteelMaterialList" ? i.mete : i.weighingTotalWeight) || 0, t += Number(i.amount) || 0;
      });
    }), s.amount = O(t, x.YUAN), s.mete = e, s.meteUnit = "kg";
  });
  const a = d({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }), P = (e) => {
    const t = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, n = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null };
    ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"].forEach((i) => {
      g(e[i]) && (e[i] = e[i].map((l) => d(l)), t[i] = h(a, (l) => {
        l[i] && (n[i] = h(m, () => {
          e[i].forEach((o) => {
            var f;
            return (f = l[i]) == null ? void 0 : f.rowWatch(o);
          }), m.value && (m.value.initSelected(e[i].map((o) => ({ sn: o.sn, classifyId: o.classifyId }))), S(() => {
            n[i]();
          }));
        }, { immediate: true }), S(() => {
          t[i]();
        }));
      }, { immediate: true, deep: true }));
    });
  };
  h(() => s.currentBasicClass, (e) => {
    e && S(() => {
      var n;
      let t = "";
      switch (e) {
        case c.STEEL_PLATE.V:
          t = "steelPlateList";
          break;
        case c.SECTION_STEEL.V:
          t = "sectionSteelList";
          break;
        case c.STEEL_COIL.V:
          t = "steelCoilList";
          break;
        default:
          t = "otherSteelMaterialList";
          break;
      }
      a[t] || (a[t] = u.value), (n = s[t]) == null || n.forEach((r) => {
        var i;
        return (i = p[t]) == null ? void 0 : i.rowWatch(r);
      });
    });
  }, { immediate: true });
  const b = D(() => {
    switch (s.currentBasicClass) {
      case c.STEEL_PLATE.V:
        return B;
      case c.SECTION_STEEL.V:
        return $;
      case c.STEEL_COIL.V:
        return v;
      default:
        return A;
    }
  });
  function M(e) {
    var t;
    return (t = u.value) == null ? void 0 : t.rowInit(e);
  }
  function E() {
    s.list = [...s.steelPlateList, ...s.sectionSteelList, ...s.steelCoilList, ...s.otherSteelMaterialList], s.list.forEach((e) => {
      e.basicClass !== c.OTHER_STEEL_MATERIALS.V && (e.mete = e.weighingTotalWeight, e.weight = e.weighingTotalWeight);
    });
  }
  function V() {
    if (L(s.steelPlateList) && L(s.sectionSteelList) && L(s.steelCoilList) && L(s.otherSteelMaterialList)) return C.warning("请填写数据"), false;
    const e = I(), t = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"], n = ["钢材列表", "型材列表", "钢卷列表", "其它钢材列表"];
    let r = 0, i = true;
    for (let l = 0; l < t.length; l++) s[t[l]].forEach((o) => {
      const f = t[l] === "otherSteelMaterialList" ? "mete" : "weighingTotalWeight";
      if (!o[f] || !o.unitPrice || !o.amount) return i = false, r = l, false;
    });
    return i ? (e && E(), e) : (C.error(`${n[r]}重量单价必填`), false);
  }
  function I() {
    return Object.keys(a).every((e) => a[e] ? a[e].validate() : true);
  }
  function R() {
    return Object.keys(a).every((e) => a[e] ? a[e].TSValidate() : true);
  }
  function W(e) {
    var t;
    (t = u.value) == null || t.rowWatch(e);
  }
  return w({ rowInit: M, validate: V, rowWatch: W, setFormCallback: P, getData: E, TSValidateTable: R }), (e, t) => (j(), F(k(b.value), U({ ref_key: "steelRef", ref: u }, e.$attrs), null, 16));
} };
export {
  Q as default
};
