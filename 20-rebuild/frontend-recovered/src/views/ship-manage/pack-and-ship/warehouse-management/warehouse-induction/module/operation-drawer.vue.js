import { inject as T } from "vue";
import { ref as f } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as g } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createTextVNode as A } from "vue";
import { createCommentVNode as V } from "vue";
import { createVNode as e } from "vue";
import { isRef as P } from "vue";
import { ElMessage as k } from "element-plus";
import { ElNotification as W } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElInputNumber as O } from "element-plus";
import { l as I, u as Q, o as G, G as K, fm as J } from "../../../../../../shared/runtime.js";
import { o as X } from "../../../../../../modules/one-code-number-list-af2f89eb.js";
import { _ as Y } from "../../../../../../modules/index-c07af747.js";
import { m as Z } from "../../../../../../modules/manuf-warehouse-select-bae65ecc.js";
function ee(d) {
  return I({ url: "/api/mes/building/warehouseManagement/getUnSaveWarehouseProductList", method: "get", params: d });
}
function oe(d) {
  return I({ url: "/api/mes/building/warehouseManagement/saveWarehouseProduct", method: "post", data: d });
}
const se = { get: ee }, te = { __name: "operation-drawer", props: { visible: { type: Boolean, default: false }, operationList: { type: Array, default: () => [] } }, emits: ["update:visible", "deleteRow", "refresh"], setup(d, { emit: L }) {
  const C = T("permission"), N = f(), h = L, v = d, { visible: m, handleClose: y } = Q({ emit: h, props: v, field: "visible", showHook: q }), { maxHeight: R } = G({ mainBox: ".warehouse-induction-operation-drawer", extraBox: [".el-drawer__header", ".form-box"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 20 }, () => m.value), M = f([]), w = f(false), r = f({});
  function x(n) {
    return n.warehouseNumberModeEnum === J.MANUAL.V && n.originNumberList.length;
  }
  function U(n, o) {
    var i;
    if (x(o)) {
      const p = ((i = o.originNumberList) == null ? void 0 : i.map((c) => c.number)) || [];
      o.numberList = p.slice(0, n);
    }
  }
  function E(n) {
    h("deleteRow", n);
  }
  function q() {
  }
  async function B() {
    if (!r.value.workshopId) return k.warning("请选择车间");
    if (!r.value.warehouseId) return k.warning("请选择库位");
    try {
      w.value = true;
      const n = v.operationList.map((o) => {
        var i;
        return { numberList: o.numberList, productId: o.productId, productType: o.productType, quantity: o.quantity, workshopId: (i = o.workshop) == null ? void 0 : i.id, warehouseId: r.value.warehouseId };
      });
      await oe(n), W({ title: "保存成功", type: "success", duration: 2500 }), y(), h("refresh"), r.value = {};
    } catch (n) {
      console.log("保存失败", n);
    } finally {
      w.value = false;
    }
  }
  function j(n) {
    n.quantity = n.numberList.length;
  }
  return (n, o) => {
    const i = b("common-button"), p = D, c = F, a = $, H = O, S = b("common-table"), z = b("common-drawer");
    return g(), _(z, { ref_key: "drawerRef", ref: N, title: "选择库位", "custom-class": "warehouse-induction-operation-drawer", modelValue: s(m), "onUpdate:modelValue": o[2] || (o[2] = (t) => P(m) ? m.value = t : null), direction: "rtl", "before-close": s(y), size: "80%" }, { titleRight: l(() => [s(K)(s(C).submit) ? (g(), _(i, { key: 0, onClick: B, loading: w.value, type: "primary" }, { default: l(() => o[3] || (o[3] = [A(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])) : V("", true)]), content: l(() => [e(c, { ref: "formRef", size: "small", class: "form-box" }, { default: l(() => [e(p, { label: "选择库位" }, { default: l(() => [e(s(Y), { modelValue: r.value.workshopId, "onUpdate:modelValue": o[0] || (o[0] = (t) => r.value.workshopId = t), clearable: "", style: { width: "270px", "margin-right": "10px" } }, null, 8, ["modelValue"]), e(s(Z), { modelValue: r.value.warehouseId, "onUpdate:modelValue": o[1] || (o[1] = (t) => r.value.warehouseId = t), "workshop-id": r.value.workshopId, clearable: "", style: { width: "270px" } }, null, 8, ["modelValue", "workshop-id"])]), _: 1 })]), _: 1 }, 512), e(S, { ref: "tableRef", data: d.operationList, "max-height": s(R), "expand-row-keys": M.value, "default-expand-all": "", "return-source-data": "", style: { width: "100%" }, "row-key": "productId" }, { default: l(() => [e(a, { type: "expand" }, { default: l(({ row: t }) => [x(t) ? (g(), _(c, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: l(() => [e(p, { label: "一物一码编号：" }, { default: l(() => [e(s(X), { modelValue: t.numberList, "onUpdate:modelValue": (u) => t.numberList = u, list: t.originNumberList, color: "#ffff00", "tag-width": 100, onChange: (u) => j(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : V("", true)]), _: 1 }), e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "workshop.name", align: "center", "show-overflow-tooltip": true, label: "车间", "min-width": "100" }), e(a, { prop: "project.serialNumber", align: "center", "show-overflow-tooltip": true, label: "项目编号", "min-width": "100" }), e(a, { prop: "project.name", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "140" }), e(a, { prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "100" }), e(a, { prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域", "min-width": "100" }), e(a, { prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }), e(a, { prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号", "min-width": "100" }), e(a, { prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格", "min-width": "120" }), e(a, { prop: "length", align: "center", "show-overflow-tooltip": true, label: "长度", width: "100" }), e(a, { prop: "originQuantity", align: "center", "show-overflow-tooltip": true, label: "入库数", width: "100" }), e(a, { prop: "netWeight", align: "center", "show-overflow-tooltip": true, label: "单重", width: "100" }), e(a, { prop: "quantity", align: "center", "show-overflow-tooltip": true, label: "操作数", width: "140" }, { default: l(({ row: t }) => [e(H, { modelValue: t.quantity, "onUpdate:modelValue": (u) => t.quantity = u, step: 1, min: 1, max: t.originQuantity, style: { width: "100%" }, "controls-position": "right", onChange: (u) => U(u, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), e(a, { align: "center", label: "操作", width: "80" }, { default: l(({ $index: t }) => [e(i, { size: "small", icon: "el-icon-delete", type: "danger", onClick: (u) => E(t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = Object.freeze(Object.defineProperty({ __proto__: null, default: te }, Symbol.toStringTag, { value: "Module" }));
export {
  te as _,
  se as c,
  ue as o
};
