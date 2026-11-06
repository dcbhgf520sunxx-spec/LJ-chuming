import { ref as u } from "vue";
import { computed as T } from "vue";
import { watch as P } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as k } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as x } from "vue";
import { unref as n } from "vue";
import { Fragment as N } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as O } from "vue";
import { withDirectives as j } from "vue";
import { ElTag as z } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as S } from "element-plus";
import { d as U, e as $, m as F } from "../../../../modules/production-order-334bd558.js";
import { F as o, o as K, i as R, c5 as X, bV as G, D as J } from "../../../../shared/runtime.js";
const Q = { class: "detail-container" }, Y = { style: { "margin-bottom": "10px", "min-height": "28px" }, class: "tag-div" }, Z = { style: { float: "left" } }, ee = { style: { float: "right" } }, te = { key: 0 }, ae = { key: 1 }, ie = { __name: "type-detail", props: { currentRow: { type: Object, default: () => {
} }, productType: { type: [Number, String], default: void 0 } }, setup(s) {
  const e = s, b = u([]), d = u(false), V = u([]), r = u(), m = u(), f = T(() => ({ projectId: e.currentRow.projectId, material: e.currentRow.material, classificationName: e.currentRow.classificationName })), E = T(() => e.productType === o.MACHINE_PART.V ? "bridgeMachinePartClassList" : e.productType === o.BOX.V ? "bridgeBoxClassList" : "bridgeElementClassList"), { maxHeight: B } = K({ extraBox: ".tag-div", wrapperBox: [".app-container", ".detail-container"] });
  P(() => f.value, (y) => {
    if (y) {
      if (V.value = [], m.value = void 0, r.value = void 0, e.productType === o.MACHINE_PART.V && R(e.currentRow.specifications)) for (let t = 0; t < e.currentRow.specifications.length; t++) V.value.push({ label: "PL=" + e.currentRow.specifications[t], value: e.currentRow.specifications[t] });
      v();
    }
  }, { deep: true, immediate: true });
  async function v() {
    if (b.value = [], !e.currentRow.projectId) return;
    d.value = true;
    const y = e.productType === o.MACHINE_PART.V ? { ...f.value, boolHaveHole: m.value, specification: r.value } : { ...f.value };
    try {
      const t = e.productType === o.BOX.V ? U : e.productType === o.CELL.V ? $ : F, { content: g } = await t({ ...y });
      b.value = g, d.value = false;
    } catch (t) {
      console.log("获取详情失败", t), d.value = false;
    }
  }
  return (y, t) => {
    const g = z, H = h("common-select"), A = h("common-radio-button"), L = W, D = h("print-table"), c = q, I = h("common-table"), M = S;
    return a(), p("div", Q, [k("div", Y, [k("div", Z, [e.currentRow.classificationId === null ? (a(), _(g, { key: 0, size: "large" }, { default: w(() => [C(x(`${n(o).VL[s.productType]}分类：`) + "未知类型", 1)]), _: 1 })) : (a(), _(g, { key: 1, size: "large" }, { default: w(() => [C(x(`${n(o).VL[s.productType]}分类：${s.currentRow.classificationName}`), 1)]), _: 1 })), s.productType === n(o).MACHINE_PART.V ? (a(), p(N, { key: 2 }, [n(R)(s.currentRow.specifications) ? (a(), p(N, { key: 0 }, [i(H, { modelValue: r.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => r.value = l), options: V.value, type: "other", size: "default", dataStructure: { key: "label", label: "label", value: "value" }, clearable: "", placeholder: "请选择厚度", style: { width: "200px", margin: "0 10px" }, onChange: v }, null, 8, ["modelValue", "options"]), i(A, { modelValue: m.value, "onUpdate:modelValue": t[1] || (t[1] = (l) => m.value = l), options: n(X).ENUM, showOptionAll: "", size: "default", optionAllValue: void 0, type: "enum", style: { "vertical-align": "middle" }, onChange: v }, null, 8, ["modelValue", "options"])], 64)) : (a(), _(L, { key: 1, modelValue: r.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => r.value = l), modelModifiers: { trim: true }, type: "text", placeholder: "请输入规格", style: { width: "200px", margin: "0 10px" }, onBlur: v }, null, 8, ["modelValue"]))], 64)) : O("", true)]), k("div", ee, [i(D, { "api-key": E.value, params: { ...f.value }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), j((a(), _(I, { data: b.value, "max-height": n(B) - 140 }, { default: w(() => [i(c, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), i(c, { key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }), i(c, { key: "length", prop: "length", label: "长度", align: "center", "show-overflow-tooltip": true }), i(c, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), i(c, { key: "netWeight", prop: "netWeight", label: "单量（kg）", align: "center", "show-overflow-tooltip": true }, { default: w((l) => [l.row.netWeight ? (a(), p("span", te, x(n(G)(l.row.netWeight, n(J).COM_WT__KG)), 1)) : (a(), p("span", ae, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[M, d.value]])]);
  };
} };
export {
  ie as default
};
