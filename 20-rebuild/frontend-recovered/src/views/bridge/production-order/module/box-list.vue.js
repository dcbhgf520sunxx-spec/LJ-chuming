import { ref as l } from "vue";
import { watch as D } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as g } from "vue";
import { withCtx as i } from "vue";
import { unref as o } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as I } from "vue";
import { ElCol as M } from "element-plus";
import { ElRow as R } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as W } from "element-plus";
import { b as S, a as j } from "../../../../modules/production-order-334bd558.js";
import { _ as A, F as d, o as H, bV as X, D as F, i as $ } from "../../../../shared/runtime.js";
import G from "./type-detail.vue.js";
import b from "./components/Panel/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const K = { style: { display: "flex", "margin-top": "15px" } }, U = { style: { width: "45%", "padding-right": "10px" }, class: "tree-list" }, z = { key: 0, style: { color: "red" } }, J = { key: 1 }, Y = { key: 0 }, Z = { key: 1 }, tt = { style: { width: "54%", "padding-left": "10px" } }, et = { key: 1, class: "my-code" }, at = { __name: "box-list", props: { currentId: { type: [String, Number], default: void 0 }, drawerVisible: { type: Boolean, require: true } }, setup(N) {
  const s = N, v = l([]), u = l(false), n = l(d.BOX.V), _ = l({}), m = l({}), { maxHeight: T } = H({ extraBox: ".tag-div", wrapperBox: [".app-container", ".tree-list"] }), B = l([["auditReceiptTime", "parse-time"]]), V = l([d.BOX, d.CELL, d.MACHINE_PART]);
  D(() => s.drawerVisible, (t) => {
    t && (n.value = d.BOX.V, _.value = {}, x(), q());
  }, { deep: true, immediate: true });
  async function q() {
    if (m.value = {}, !!s.currentId) {
      u.value = true;
      try {
        const t = await S({ projectId: s.currentId, productType: n.value });
        m.value = { boxQuantity: [{ quantity: t.boxQuantity || 0, unit: "件", precision: 0 }, { quantity: t.boxMete || 0, unit: "kg", precision: 2 }], elementQuantity: [{ quantity: t.elementQuantity || 0, unit: "件", precision: 0 }, { quantity: t.elementMete || 0, unit: "kg", precision: 2 }], machinePartQuantity: [{ quantity: t.machinePartQuantity || 0, unit: "件", precision: 0 }, { quantity: t.machinePartMete || 0, unit: "kg", precision: 2 }] };
      } catch (t) {
        console.log("获取分段零件清单汇总失败", t);
      }
    }
  }
  async function x() {
    if (v.value = [], !!s.currentId) {
      u.value = true;
      try {
        const t = await j({ projectId: s.currentId, type: n.value });
        t.map((c) => {
          c.projectId = s.currentId;
        }), v.value = t || [], u.value = false;
      } catch (t) {
        console.log("获取分段零件清单失败", t), u.value = false;
      }
    }
  }
  function Q(t) {
    _.value = t;
  }
  return (t, c) => {
    const E = k("common-radio-button"), h = M, L = R, y = O, P = k("common-table"), w = W;
    return a(), p("div", null, [e(E, { modelValue: n.value, "onUpdate:modelValue": c[0] || (c[0] = (r) => n.value = r), options: V.value, type: "enum", style: { "margin-bottom": "10px" }, onChange: x }, null, 8, ["modelValue", "options"]), C((a(), g(L, { gutter: 30, class: "panel-group" }, { default: i(() => [e(h, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(b), { name: "分段总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.boxQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(h, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(b), { name: "单元件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.elementQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(h, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(b), { name: "零件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.machinePartQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 })]), _: 1 })), [[w, u.value]]), f("div", K, [f("div", U, [C((a(), g(P, { data: v.value, onCurrentChange: Q, "data-format": B.value, "highlight-current-row": "", "max-height": o(T) - 70 }, { default: i(() => [e(y, { key: "classificationName", prop: "classificationName", label: `${o(d).VL[n.value]}分类`, align: "center", "show-overflow-tooltip": true }, { default: i((r) => [r.row.classificationId === null ? (a(), p("span", z, "未知类型")) : (a(), p("span", J, I(r.row.classificationName), 1))]), _: 1 }, 8, ["label"]), e(y, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(y, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), e(y, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: i((r) => [r.row.totalNetWeight ? (a(), p("span", Y, I(o(X)(r.row.totalNetWeight, o(F).COM_WT__KG)), 1)) : (a(), p("span", Z, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[w, u.value]])]), c[1] || (c[1] = f("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 260px)" } }, null, -1)), f("div", tt, [o($)(_.value) ? (a(), g(o(G), { key: 0, currentRow: _.value, productType: n.value }, null, 8, ["currentRow", "productType"])) : (a(), p("div", et, "*点击左表操作查看明细"))])])]);
  };
} }, ut = A(at, [["__scopeId", "data-v-409cc4f4"]]);
export {
  ut as default
};
