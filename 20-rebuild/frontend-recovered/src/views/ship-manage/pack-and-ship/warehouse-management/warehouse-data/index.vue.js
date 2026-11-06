import { ref as d } from "vue";
import { watch as U } from "vue";
import { onMounted as z } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as m } from "vue";
import { normalizeStyle as H } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as i } from "vue";
import { withCtx as g } from "vue";
import { toDisplayString as _ } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTree as A } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as J, p as X, w as Y, _ as Z } from "./module/operation-drawer.vue.js";
import { _ as ee, x as oe, o as te, z as ae, P as re } from "../../../../../shared/runtime.js";
import { w as le } from "../../../../../modules/ship-manage-3066b2ed.js";
import ne from "./module/header.vue.js";
import "../../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../../modules/index-c07af747.js";
import "../../../../../modules/manuf-warehouse-select-bae65ecc.js";
const ie = { class: "app-container wrap" }, se = { class: "wrap-left" }, ue = { style: { padding: "3px 0px", "border-radius": "3px", width: "100%" }, class: "flex-rbc" }, pe = { style: { "font-weight": "bold" } }, ce = { class: "wrap-right" }, de = { class: "head-container" }, he = { __name: "index", setup(me) {
  const V = { add: false, edit: false, del: false, download: false }, y = d(), { crud: o, columns: p, CRUD: D } = oe({ title: "库位数据", sort: [], permission: { ...le }, optShow: { ...V }, crudApi: { ...J } }, y), { maxHeight: j } = te({ paginate: true }), w = d(), v = d(false), Q = d(), C = d([]), k = d({}), W = { children: "warehouseList", label: "label" }, x = d(false), q = d(false), I = d([]);
  D.HOOK.handleRefresh = (l, t) => {
    t.data.content = t.data.content.map((c) => {
      var a;
      return c.originQuantity = c.quantity, c.originNumberList = ((a = c.numberList) == null ? void 0 : a.map((r) => ({ number: r }))) || [], c;
    });
  }, U(() => w.value, () => {
    o.query.projectId = w.value, N();
  }, { immediate: true }), z(() => {
    M();
  });
  async function M() {
    try {
      q.value = true;
      const { content: l } = await X();
      I.value = l.map((t) => (t.fullname = ae(t), t));
    } catch (l) {
      console.log("获取项目列表", l);
    } finally {
      q.value = false;
    }
  }
  async function N() {
    try {
      k.value = {}, v.value = true;
      let l = true, t = true;
      const { content: c } = await Y({ projectId: w.value });
      c.forEach((a) => {
        o.query.workshopId && a.workshop.id === o.query.workshopId && (l = false), a.label = a.workshop.name, a.rowKey = "workshop" + a.workshop.id, a.type = "workshop", a.workshopId = a.workshop.id, k.value[a.rowKey] = a, a.warehouseList.forEach((r) => {
          o.query.warehouseId && r.warehouse.id === o.query.warehouseId && (t = false), r.label = r.warehouse.name, r.id = r.warehouse.id, r.rowKey = "warehouse" + r.warehouse.id, r.type = "warehouse", r.warehouseId = r.warehouse.id, k.value[r.rowKey] = r;
        });
      }), l && (o.query.workshopId = void 0), t && (o.query.warehouseId = void 0), C.value = c;
    } catch (l) {
      console.log("获取库位数据汇总", l);
    } finally {
      v.value = false, o.toQuery();
    }
  }
  function E(l) {
    y.value.toggleRowSelection(l, false);
  }
  function K(l) {
    o.query.workshopId = l.workshopId, o.query.warehouseId = l.warehouseId, o.toQuery();
  }
  function P() {
    y.value.clearSelection(), N(), o.toQuery();
  }
  return (l, t) => {
    const c = L("common-select"), a = $, r = A, s = F, T = L("common-table"), S = G;
    return n(), B("div", ie, [f("div", se, [m(c, { modelValue: w.value, "onUpdate:modelValue": t[0] || (t[0] = (h) => w.value = h), options: I.value, type: "other", clearable: "", dataStructure: { key: "id", label: "fullname", value: "id" }, size: "small", filterable: "", placeholder: "请选择项目", style: { width: "100%", "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), f("div", { style: H(`max-height: ${e(j) + 50}px; overflow: auto;`) }, [R((n(), i(r, { ref_key: "treeMenuRef", ref: Q, data: C.value, props: W, "highlight-current": "", "expand-on-click-node": false, "default-expand-all": true, "node-key": "rowKey", onNodeClick: K }, { default: g(({ node: h, data: b }) => [f("div", ue, [f("span", pe, _(h.label), 1), m(a, { type: b.type === "workshop" ? "primary" : "info", effect: "plain", style: {} }, { default: g(() => [O(_(b.type === "workshop" ? "总库存" : "库存") + "：" + _(b.quantity) + "件 | " + _(b.totalWeight) + "吨 ", 1)]), _: 2 }, 1032, ["type"])])]), _: 1 }, 8, ["data"])), [[S, v.value]])], 4)]), f("div", ce, [f("div", de, [m(e(ne), { onOperation: t[2] || (t[2] = (h) => x.value = true) }, { project: g(() => [w.value ? u("", true) : (n(), i(c, { key: 0, modelValue: e(o).query.projectId, "onUpdate:modelValue": t[1] || (t[1] = (h) => e(o).query.projectId = h), options: I.value, type: "other", clearable: "", class: "filter-item", dataStructure: { key: "id", label: "fullname", value: "id" }, size: "small", filterable: "", placeholder: "请选择项目", style: { width: "270px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]))]), _: 1 })]), R((n(), i(T, { ref_key: "tableRef", ref: y, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(j), style: { width: "100%", overflow: "hidden" }, onSelectionChange: e(o).selectionChangeHandler }, { default: g(() => [m(s, { type: "selection", align: "center", width: "45", class: "selection" }), m(s, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("project.serialNumber") ? (n(), i(s, { key: "project.serialNumber", prop: "project.serialNumber", align: "center", "show-overflow-tooltip": true, label: "项目编号", "min-width": "100" })) : u("", true), e(p).visible("project.name") ? (n(), i(s, { key: "project.name", prop: "project.name", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "140" })) : u("", true), e(p).visible("monomer.name") ? (n(), i(s, { key: "monomer.name", prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "100" })) : u("", true), e(p).visible("area.name") ? (n(), i(s, { key: "area.name", prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域", "min-width": "100" })) : u("", true), e(p).visible("warehouse.name") && !e(o).query.warehouseId ? (n(), i(s, { key: "warehouse.name", prop: "warehouse.name", align: "center", "show-overflow-tooltip": true, label: "库位", "min-width": "100" })) : u("", true), e(p).visible("name") ? (n(), i(s, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "100" })) : u("", true), e(p).visible("serialNumber") ? (n(), i(s, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号", "min-width": "100" })) : u("", true), e(p).visible("specification") ? (n(), i(s, { key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })) : u("", true), e(p).visible("length") ? (n(), i(s, { key: "length", prop: "length", align: "center", "show-overflow-tooltip": true, label: "长度", width: "100" })) : u("", true), e(p).visible("originQuantity") ? (n(), i(s, { key: "originQuantity", prop: "originQuantity", align: "center", "show-overflow-tooltip": true, label: "库存数", width: "100" })) : u("", true), e(p).visible("netWeight") ? (n(), i(s, { key: "netWeight", prop: "netWeight", align: "center", "show-overflow-tooltip": true, label: "单重", width: "100" })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[S, e(o).loading]]), m(e(re)), m(e(Z), { visible: x.value, "onUpdate:visible": t[3] || (t[3] = (h) => x.value = h), operationList: e(o).selections, onDeleteRow: E, onRefresh: P }, null, 8, ["visible", "operationList"])])]);
  };
} }, Ie = ee(he, [["__scopeId", "data-v-9e76b184"]]);
export {
  Ie as default
};
