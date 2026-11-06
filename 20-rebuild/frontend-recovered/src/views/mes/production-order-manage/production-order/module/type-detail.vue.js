import { ref as u } from "vue";
import { computed as A } from "vue";
import { watch as S } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as V } from "vue";
import { createBlock as d } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as R } from "vue";
import { toDisplayString as k } from "vue";
import { unref as l } from "vue";
import { Fragment as x } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as j } from "vue";
import { ElTag as W } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as O } from "element-plus";
import { d as U, e as z, m as $ } from "../../../../../modules/production-order-028b54f6.js";
import { a3 as o, o as K, i as N, c5 as G, bV as J, D as Q } from "../../../../../shared/runtime.js";
const X = { class: "detail-container" }, Y = { style: { "margin-bottom": "10px", "min-height": "28px" }, class: "tag-div" }, Z = { style: { float: "left" } }, ee = { style: { float: "right" } }, te = { key: 0 }, ae = { key: 1 }, ie = { __name: "type-detail", props: { currentRow: { type: Object, default: () => {
} }, productType: { type: [Number, String], default: void 0 } }, setup(s) {
  const e = s, b = u([]), m = u(false), T = u([]), r = u(), f = u(), y = A(() => ({ projectId: e.currentRow.projectId, material: e.currentRow.material, classificationName: e.currentRow.classificationName })), E = A(() => e.productType === o.MACHINE_PART.V ? "mesMachinePartClassList" : e.productType === o.ARTIFACT.V ? "mesArtifactClassList" : "mesAssembleClassList"), { maxHeight: I } = K({ extraBox: ".tag-div", wrapperBox: [".app-container", ".detail-container"] });
  S(() => y.value, (h) => {
    if (h) {
      if (T.value = [], f.value = void 0, r.value = void 0, e.productType === o.MACHINE_PART.V && N(e.currentRow.specifications)) for (let t = 0; t < e.currentRow.specifications.length; t++) T.value.push({ label: "PL=" + e.currentRow.specifications[t], value: e.currentRow.specifications[t] });
      v();
    }
  }, { deep: true, immediate: true });
  async function v() {
    if (b.value = [], !e.currentRow.projectId) return;
    m.value = true;
    const h = e.productType === o.MACHINE_PART.V ? { ...y.value, boolHaveHole: f.value, specification: r.value } : { ...y.value };
    try {
      const t = e.productType === o.ARTIFACT.V ? U : e.productType === o.ASSEMBLE.V ? z : $, { content: g } = await t({ ...h });
      b.value = g, m.value = false;
    } catch (t) {
      console.log("获取详情失败", t), m.value = false;
    }
  }
  return (h, t) => {
    const g = W, H = w("common-select"), M = w("common-radio-button"), B = q, D = w("print-table"), c = F, L = w("common-table"), P = O;
    return a(), p("div", X, [V("div", Y, [V("div", Z, [e.currentRow.classificationId === null ? (a(), d(g, { key: 0 }, { default: _(() => [R(k(`${l(o).VL[s.productType]}分类:`) + "未知类型", 1)]), _: 1 })) : (a(), d(g, { key: 1 }, { default: _(() => [R(k(`${l(o).VL[s.productType]}分类:${s.currentRow.classificationName}`), 1)]), _: 1 })), s.productType === l(o).MACHINE_PART.V ? (a(), p(x, { key: 2 }, [l(N)(s.currentRow.specifications) ? (a(), p(x, { key: 0 }, [i(H, { modelValue: r.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => r.value = n), options: T.value, type: "other", size: "default", dataStructure: { key: "label", label: "label", value: "value" }, clearable: "", placeholder: "请选择厚度", style: { width: "200px", margin: "0 10px" }, onChange: v }, null, 8, ["modelValue", "options"]), i(M, { modelValue: f.value, "onUpdate:modelValue": t[1] || (t[1] = (n) => f.value = n), options: l(G).ENUM, showOptionAll: "", size: "default", optionAllValue: void 0, type: "enum", style: { "vertical-align": "middle" }, onChange: v }, null, 8, ["modelValue", "options"])], 64)) : (a(), d(B, { key: 1, modelValue: r.value, "onUpdate:modelValue": t[2] || (t[2] = (n) => r.value = n), modelModifiers: { trim: true }, type: "text", placeholder: "请输入规格", style: { width: "200px", margin: "0 10px" }, onBlur: v }, null, 8, ["modelValue"]))], 64)) : C("", true)]), V("div", ee, [i(D, { "api-key": E.value, params: { ...y.value }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), j((a(), d(L, { data: b.value, "max-height": l(I) - 140 }, { default: _(() => [s.productType === l(o).ARTIFACT.V ? (a(), d(c, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true })) : C("", true), i(c, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), i(c, { key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }), i(c, { key: "length", prop: "length", label: "长度", align: "center", "show-overflow-tooltip": true }), i(c, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), i(c, { key: "netWeight", prop: "netWeight", label: "单量（kg）", align: "center", "show-overflow-tooltip": true }, { default: _((n) => [n.row.netWeight ? (a(), p("span", te, k(l(J)(n.row.netWeight, l(Q).COM_WT__KG)), 1)) : (a(), p("span", ae, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[P, m.value]])]);
  };
} };
export {
  ie as default
};
