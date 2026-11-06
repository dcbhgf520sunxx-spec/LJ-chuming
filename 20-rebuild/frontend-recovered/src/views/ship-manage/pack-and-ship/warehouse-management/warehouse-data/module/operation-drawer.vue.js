import { inject as I } from "vue";
import { ref as h } from "vue";
import { computed as P } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as v } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { unref as i } from "vue";
import { createTextVNode as D } from "vue";
import { createCommentVNode as L } from "vue";
import { createVNode as e } from "vue";
import { isRef as F } from "vue";
import { ElMessage as C } from "element-plus";
import { ElNotification as $ } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElForm as Q } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElInputNumber as K } from "element-plus";
import { l as w, u as J, o as X, G as Y, fm as Z } from "../../../../../../shared/runtime.js";
import { o as ee } from "../../../../../../modules/one-code-number-list-af2f89eb.js";
import { _ as oe } from "../../../../../../modules/index-c07af747.js";
import { m as te } from "../../../../../../modules/manuf-warehouse-select-bae65ecc.js";
function ae(n) {
  return w({ url: "/api/mes/building/warehouseManagement/getSaveWarehouseProductList", method: "get", params: n });
}
function me(n) {
  return w({ url: "/api/mes/building/warehouseManagement/workshopWarehouseSummary", method: "get", params: n });
}
function re(n) {
  return w({ url: "/api/mes/building/warehouseManagement/moveWarehouseProduct", method: "post", data: n });
}
function pe(n) {
  return w({ url: "/api/mes/building/warehouseManagement/workshopWarehouse/projectList", method: "get", params: n });
}
const ce = { get: ae }, le = { __name: "operation-drawer", props: { visible: { type: Boolean, default: false }, operationList: { type: Array, default: () => [] } }, emits: ["update:visible", "deleteRow", "refresh"], setup(n, { emit: N }) {
  const M = I("permission"), R = h(), f = N, b = n, { visible: m, handleClose: x } = J({ emit: f, props: b, field: "visible", showHook: U }), { maxHeight: q } = X({ mainBox: ".warehouse-data-operation-drawer", extraBox: [".el-drawer__header", ".form-box"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 20 }, () => m.value), V = I("crud"), W = h([]), g = h(false), s = h({}), j = P(() => b.operationList.map((a) => a.warehouseId));
  function k(a) {
    return a.warehouseNumberModeEnum === Z.MANUAL.V && a.originNumberList.length;
  }
  function E(a, o) {
    var u;
    if (k(o)) {
      const p = ((u = o.originNumberList) == null ? void 0 : u.map((c) => c.number)) || [];
      o.numberList = p.slice(0, a);
    }
  }
  function S(a) {
    f("deleteRow", a);
  }
  function U() {
  }
  async function B() {
    if (!s.value.workshopId) return C.warning("请选择车间");
    if (!s.value.warehouseId) return C.warning("请选择库位");
    try {
      g.value = true;
      const a = b.operationList.map((o) => {
        var u;
        return { numberList: o.numberList, productId: o.productId, productType: o.productType, quantity: o.quantity, workshopId: (u = o.workshop) == null ? void 0 : u.id, warehouseId: o.warehouseId, moveWarehouseId: s.value.warehouseId };
      });
      await re(a), $({ title: "保存成功", type: "success", duration: 2500 }), x(), f("refresh"), s.value = {};
    } catch (a) {
      console.log("保存失败", a);
    } finally {
      g.value = false;
    }
  }
  function H(a) {
    a.quantity = a.numberList.length;
  }
  return (a, o) => {
    const u = _("common-button"), p = O, c = Q, r = G, z = K, A = _("common-table"), T = _("common-drawer");
    return v(), y(T, { ref_key: "drawerRef", ref: R, title: "移库办理", "custom-class": "warehouse-data-operation-drawer", modelValue: i(m), "onUpdate:modelValue": o[2] || (o[2] = (t) => F(m) ? m.value = t : null), direction: "rtl", "before-close": i(x), size: "80%" }, { titleRight: l(() => [i(Y)(i(M).submit) ? (v(), y(u, { key: 0, onClick: B, loading: g.value, type: "primary" }, { default: l(() => o[3] || (o[3] = [D(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])) : L("", true)]), content: l(() => [e(c, { ref: "formRef", size: "small", class: "form-box" }, { default: l(() => [e(p, { label: "选择库位" }, { default: l(() => [e(i(oe), { disabledVal: i(V).query.workshopId ? [i(V).query.workshopId] : [], modelValue: s.value.workshopId, "onUpdate:modelValue": o[0] || (o[0] = (t) => s.value.workshopId = t), clearable: "", style: { width: "270px", "margin-right": "10px" } }, null, 8, ["disabledVal", "modelValue"]), e(i(te), { modelValue: s.value.warehouseId, "onUpdate:modelValue": o[1] || (o[1] = (t) => s.value.warehouseId = t), disabledVal: j.value, "workshop-id": s.value.workshopId, clearable: "", style: { width: "270px" } }, null, 8, ["modelValue", "disabledVal", "workshop-id"])]), _: 1 })]), _: 1 }, 512), e(A, { ref: "tableRef", data: n.operationList, "max-height": i(q), "expand-row-keys": W.value, "default-expand-all": "", "return-source-data": "", style: { width: "100%" }, "row-key": "productId" }, { default: l(() => [e(r, { type: "expand" }, { default: l(({ row: t }) => [k(t) ? (v(), y(c, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: l(() => [e(p, { label: "一物一码编号：" }, { default: l(() => [e(i(ee), { modelValue: t.numberList, "onUpdate:modelValue": (d) => t.numberList = d, list: t.originNumberList, color: "#ffff00", "tag-width": 100, onChange: (d) => H(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : L("", true)]), _: 1 }), e(r, { label: "序号", type: "index", align: "center", width: "60" }), e(r, { prop: "project.serialNumber", align: "center", "show-overflow-tooltip": true, label: "项目编号", "min-width": "100" }), e(r, { prop: "project.name", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "140" }), e(r, { prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "100" }), e(r, { prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域", "min-width": "100" }), e(r, { prop: "warehouse.name", align: "center", "show-overflow-tooltip": true, label: "库位", "min-width": "100" }), e(r, { prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }), e(r, { prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号", "min-width": "100" }), e(r, { prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格", "min-width": "120" }), e(r, { prop: "length", align: "center", "show-overflow-tooltip": true, label: "长度", width: "100" }), e(r, { prop: "originQuantity", align: "center", "show-overflow-tooltip": true, label: "库存数", width: "100" }), e(r, { prop: "netWeight", align: "center", "show-overflow-tooltip": true, label: "单重", width: "100" }), e(r, { prop: "quantity", align: "center", "show-overflow-tooltip": true, label: "操作数", width: "140" }, { default: l(({ row: t }) => [e(z, { modelValue: t.quantity, "onUpdate:modelValue": (d) => t.quantity = d, step: 1, min: 1, max: t.originQuantity, style: { width: "100%" }, "controls-position": "right", onChange: (d) => E(d, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), e(r, { align: "center", label: "操作", width: "80" }, { default: l(({ row: t }) => [e(u, { size: "small", icon: "el-icon-delete", type: "danger", onClick: (d) => S(t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, he = Object.freeze(Object.defineProperty({ __proto__: null, default: le }, Symbol.toStringTag, { value: "Module" }));
export {
  le as _,
  ce as c,
  he as o,
  pe as p,
  me as w
};
