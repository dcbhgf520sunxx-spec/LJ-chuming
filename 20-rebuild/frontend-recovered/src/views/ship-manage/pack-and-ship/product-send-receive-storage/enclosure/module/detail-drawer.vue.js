import { ref as y } from "vue";
import { computed as F } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as l } from "vue";
import { createBlock as I } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as n } from "vue";
import { unref as r } from "vue";
import { createElementVNode as T } from "vue";
import { withKeys as Q } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as j } from "vue";
import { createElementBlock as u } from "vue";
import { isRef as W } from "vue";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { u as te, J as ne, bb as oe, ue as ae } from "../../../../../../shared/runtime.js";
import { e as le } from "../../../../../../modules/enclosure-product-receive-send-storage-2e87d697.js";
import { g as re } from "../../../../../../modules/ship-manage-3066b2ed.js";
const se = { class: "head-container" }, ie = { class: "header-div" }, ce = { key: 0 }, ue = { key: 1 }, pe = { key: 2 }, de = { key: 3 }, me = { key: 0 }, ye = { key: 1 }, ve = { key: 2 }, ge = { key: 3 }, Te = { __name: "detail-drawer", props: { showDetailDrawer: { type: Boolean }, query: { type: Object, default: () => {
} }, inventoryType: { type: Number } }, emits: ["update:showDetailDrawer"], setup(x, { emit: P }) {
  const t = x, v = y(), g = y(false), d = y([]), o = y({ enclosurePlanId: void 0, serialNumber: void 0, projectId: void 0 }), _ = F(() => ({ projectId: t.query.projectId, category: t.query.category, dateTime: t.query.dateTime, productType: t.query.productType, type: t.inventoryType })), z = P, { visible: f, handleClose: N } = te({ emit: z, props: t, field: "showDetailDrawer", showHook: p }), { handleSizeChange: q, handleCurrentChange: B, total: S, setTotalPage: E, queryPage: h } = ne({ fetchHook: p });
  async function L() {
    var s;
    try {
      if (o.value.projectId !== null) {
        const e = await ae((s = o.value) == null ? void 0 : s.projectId);
        d.value = e || [], console.log(e), d.value = d.value.filter((b) => b.category === _.value.category), console.log(d.value);
      }
    } catch (e) {
      console.log("获取围护的批次失败", e);
    }
  }
  async function p() {
    v.value = [];
    try {
      g.value = true;
      const s = await le({ ..._.value, ...o.value, ...h });
      v.value = s.content, E(s.totalElements);
    } catch (s) {
      console.log(s);
    } finally {
      g.value = false;
    }
  }
  function R() {
    o.value = {}, p();
  }
  const U = () => {
    L(), p();
  };
  return (s, e) => {
    const b = m("print-table"), H = m("common-select"), K = X, w = m("common-button"), i = Y, M = m("common-table"), O = Z, J = m("common-drawer"), $ = G("permission"), A = ee;
    return l(), I(J, { onClose: r(N), modelValue: r(f), "onUpdate:modelValue": e[4] || (e[4] = (a) => W(f) ? f.value = a : null), size: "90%", title: t.inventoryType === 1 ? "期初库存量" : t.inventoryType === 2 ? "入库量" : t.inventoryType === 3 ? "出库量" : "期末库存量" }, { titleRight: c(() => [D(n(b, { "api-key": t.inventoryType === 1 ? "enclosureTotalBeginningInventoryDetail" : t.inventoryType === 2 ? "enclosureTotalInboundInventoryDetail" : t.inventoryType === 3 ? "enclosureTotalOutboundInventoryDetail" : "enclosureTotalEndInventoryDetail", params: { ..._.value, ...o.value } }, null, 8, ["api-key", "params"]), [[$, r(re).detailPrint]])]), content: c(() => [T("div", se, [T("div", ie, [n(r(oe), { class: "filter-item", modelValue: o.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (a) => o.value.projectId = a), onChange: U, clearable: "" }, null, 8, ["modelValue"]), n(H, { modelValue: o.value.enclosurePlanId, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.value.enclosurePlanId = a), options: d.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: p }, null, 8, ["modelValue", "options"]), n(K, { modelValue: o.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (a) => o.value.serialNumber = a), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "200px", "margin-bottom": "10px", "margin-left": "3px" }, class: "filter-item", clearable: "", onKeyup: Q(p, ["enter"]) }, null, 8, ["modelValue"]), n(w, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: p, style: { "margin-left": "10px" } }, { default: c(() => e[5] || (e[5] = [V(" 搜索 ")])), _: 1, __: [5] }), n(w, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: e[3] || (e[3] = (a) => R()) }, { default: c(() => e[6] || (e[6] = [V(" 重置 ")])), _: 1, __: [6] })]), D((l(), I(M, { data: v.value }, { default: c(() => [n(i, { label: "序号", align: "center", type: "index", "min-width": "55" }), n(i, { label: "项目", align: "center", "min-width": "180", prop: "project" }, { default: c(({ row: a }) => {
      var C, k;
      return [T("span", null, j(((C = a.project) == null ? void 0 : C.serialNumber) || "") + "-" + j(((k = a.project) == null ? void 0 : k.shortName) || ""), 1)];
    }), _: 1 }), n(i, { label: "名称", align: "center", prop: "name", "min-width": "180" }), n(i, { label: "编号", align: "center", prop: "serialNumber", "min-width": "120" }), n(i, { label: "版型", align: "center", prop: "plate", "min-width": "100" }), n(i, { label: "单长", align: "center", prop: "length" }), n(i, { align: "center", prop: "quantity" }, { header: c(() => [t.inventoryType === 1 ? (l(), u("span", ce, "期初数")) : t.inventoryType === 2 ? (l(), u("span", ue, "入库数")) : t.inventoryType === 3 ? (l(), u("span", pe, "出库数")) : (l(), u("span", de, "期末数"))]), _: 1 }), n(i, { align: "center", prop: "totalLength" }, { header: c(() => [t.inventoryType === 1 ? (l(), u("span", me, "期初量")) : t.inventoryType === 2 ? (l(), u("span", ye, "入库量")) : t.inventoryType === 3 ? (l(), u("span", ve, "出库量")) : (l(), u("span", ge, "期末量"))]), _: 1 })]), _: 1 }, 8, ["data"])), [[A, g.value]]), n(O, { total: r(S), "current-page": r(h).pageNumber, "page-size": r(h).pageSize, onSizeChange: r(q), onCurrentChange: r(B), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" } }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]), _: 1 }, 8, ["onClose", "modelValue", "title"]);
  };
} };
export {
  Te as default
};
