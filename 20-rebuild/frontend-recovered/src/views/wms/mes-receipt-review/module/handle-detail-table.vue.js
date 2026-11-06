import { ref as w } from "vue";
import { inject as U } from "vue";
import { computed as F } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as a } from "vue";
import { renderSlot as K } from "vue";
import { withCtx as r } from "vue";
import { unref as l } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as _ } from "vue";
import { toDisplayString as s } from "vue";
import { ElTableColumn as q } from "element-plus";
import { am as C, jX as z, c } from "../../../../shared/runtime.js";
import X from "./outbound-detail.vue.js";
import "../../../../modules/mes-receipt-review-377f871a.js";
const G = ["onClick"], J = { key: 1 }, Q = ["onClick"], W = { key: 1 }, Y = { key: 0 }, Z = { key: 1 }, ee = ["onClick"], te = { key: 1 }, oe = ["onClick"], ne = { key: 1 }, ae = { key: 0 }, le = { key: 1 }, re = ["onClick"], ie = { key: 1 }, ue = ["onClick"], se = { key: 1 }, he = { __name: "handle-detail-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 100 }, dataShowType: { type: String, default: void 0 } }, emits: ["deleteRowSuccess"], setup(k, { expose: S, emit: E }) {
  const V = k, N = E, A = w(false), O = w({}), v = U("mainCurrentRow"), f = w(1), T = w("handled"), D = F(() => v.value.basicClass === C.SECTION_STEEL.V ? [{ value: 1, name: "重量" }, { value: 2, name: "长度" }] : [{ value: 1, name: "重量" }, { value: 2, name: "面积" }]), $ = w([...z, ["pickingAmount", ["to-fixed-field", "accountingPrecision"]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]);
  function j(p) {
    const { columns: i, data: L } = p, o = [];
    return i.forEach((h, e) => {
      if (e === 0) {
        o[e] = "合计";
        return;
      }
      const d = ["quantity", "mete", "pickingAmount", "pickingArea", "pickingLength", "volume", "handlingArea", "handlingLength", "currentOutboundMete", "currentOutboundArea", "currentOutboundLength"], H = ["pickingArea", "handlingArea", "currentOutboundArea"], M = ["pickingLength", "handlingLength", "currentOutboundLength"];
      if (d.includes(h.property)) {
        const x = L.map((y) => {
          var b;
          return (b = y.sourceRow) == null ? void 0 : b[h.property];
        });
        x.every((y) => isNaN(y)) || (o[e] = x.reduce((y, b) => {
          const P = Number(b);
          return isNaN(P) ? y : y + b;
        }, 0), H.includes(h.property) ? o[e] = c(o[e], "mm²", "㎡", 4) : M.includes(h.property) && (o[e] = c(o[e], "mm", "m", 3)));
      }
    }), o;
  }
  function m(p, i) {
    A.value = true, O.value = p, T.value = i;
  }
  function B(p) {
    N("deleteRowSuccess", p);
  }
  return S({}), (p, i) => {
    const L = R("common-radio-button"), o = q, h = R("common-table");
    return t(), n("div", null, [I("div", null, [a(L, { modelValue: f.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => f.value = e), options: D.value, type: "other", dataStructure: { key: "value", label: "name", value: "value" }, size: "default", style: { "margin-bottom": "5px" } }, null, 8, ["modelValue", "options"]), K(p.$slots, "extra")]), a(h, { data: k.list, "data-format": $.value, "max-height": V.maxHeight, "show-summary": "", "summary-method": j, "row-key": "id" }, { default: r(() => [a(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(o, { key: "pickingType", align: "left", label: "领料类型", prop: "pickingType", "show-overflow-tooltip": "", width: "100" }), l(v).basicClass === l(C).SECTION_STEEL.V ? (t(), g(o, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" })) : u("", true), l(v).basicClass === l(C).STEEL_PLATE.V ? (t(), g(o, { key: "thick", label: "厚度(mm)", align: "center", prop: "thick", "show-overflow-tooltip": "", width: "100px" })) : u("", true), a(o, { key: "material", align: "left", label: "材质", prop: "material", "show-overflow-tooltip": "", "min-width": "100" }), f.value === 1 ? (t(), g(o, { key: "unit", prop: "unit", label: "单位", align: "center", "min-width": "80px" })) : u("", true), f.value === 1 ? (t(), n(_, { key: 3 }, [a(o, { key: "pickingAmount", prop: "pickingAmount", label: "领料量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), a(o, { label: "已办理量", "show-overflow-tooltip": "", "min-width": "100px", key: "volume", prop: "volume", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.volume ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "handled") }, s(e.volume), 9, G)) : (t(), n("span", J, "-"))]), _: 1 }), k.dataShowType ? u("", true) : (t(), g(o, { label: "本次办理量", "show-overflow-tooltip": "", "min-width": "100px", key: "currentOutboundMete", prop: "currentOutboundMete", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.currentOutboundMete ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "current") }, s(e.currentOutboundMete), 9, Q)) : (t(), n("span", W, "-"))]), _: 1 }))], 64)) : u("", true), f.value === 2 ? (t(), n(_, { key: 4 }, [l(v).basicClass === l(C).STEEL_PLATE.V ? (t(), n(_, { key: 0 }, [a(o, { key: "pickingArea", prop: "pickingArea", label: "领料面积(㎡)", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: r(({ row: { sourceRow: e } }) => [e.pickingArea ? (t(), n("span", Y, s(l(c)(e.pickingArea, "mm²", "㎡", 4)), 1)) : (t(), n("span", Z, "-"))]), _: 1 }), a(o, { label: "已办理面积(㎡)", "show-overflow-tooltip": "", "min-width": "100px", key: "handlingArea", prop: "handlingArea", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.handlingArea ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "handled") }, s(l(c)(e.handlingArea, "mm²", "㎡", 4)), 9, ee)) : (t(), n("span", te, "-"))]), _: 1 }), k.dataShowType ? u("", true) : (t(), g(o, { label: "本次办理面积(㎡)", "show-overflow-tooltip": "", "min-width": "100px", key: "currentOutboundArea", prop: "currentOutboundArea", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.currentOutboundArea ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "current") }, s(l(c)(e.currentOutboundArea, "mm²", "㎡", 4)), 9, oe)) : (t(), n("span", ne, "-"))]), _: 1 }))], 64)) : (t(), n(_, { key: 1 }, [a(o, { key: "pickingLength", prop: "pickingLength", label: "领用长度(m)", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }, { default: r(({ row: { sourceRow: e } }) => [e.pickingLength ? (t(), n("span", ae, s(l(c)(e.pickingLength, "mm", "m", 3)), 1)) : (t(), n("span", le, "-"))]), _: 1 }), a(o, { label: "已办理长度(m)", "show-overflow-tooltip": "", "min-width": "100px", key: "handlingLength", prop: "handlingLength", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.handlingLength ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "handled") }, s(l(c)(e.handlingLength, "mm", "m", 3)), 9, re)) : (t(), n("span", ie, "-"))]), _: 1 }), k.dataShowType ? u("", true) : (t(), g(o, { label: "本次办理长度(m)", "show-overflow-tooltip": "", "min-width": "100px", key: "currentOutboundLength", prop: "currentOutboundLength", align: "center" }, { default: r(({ row: { sourceRow: e } }) => [e.currentOutboundLength ? (t(), n("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (d) => m(e, "current") }, s(l(c)(e.currentOutboundLength, "mm", "m", 3)), 9, ue)) : (t(), n("span", se, "-"))]), _: 1 }))], 64))], 64)) : u("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"]), a(X, { outboundListCurrentRow: O.value, modelValue: A.value, "onUpdate:modelValue": i[1] || (i[1] = (e) => A.value = e), onDeleteRow: B, outboundHandledType: T.value }, null, 8, ["outboundListCurrentRow", "modelValue", "outboundHandledType"])]);
  };
} };
export {
  he as default
};
