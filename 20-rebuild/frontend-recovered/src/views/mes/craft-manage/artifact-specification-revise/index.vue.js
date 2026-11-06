import { ref as w } from "vue";
import { watch as x } from "vue";
import { provide as P } from "vue";
import { resolveComponent as J } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as X } from "vue";
import { createBlock as s } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as b } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { InfoFilled as Z } from "@element-plus/icons-vue";
import { ElIcon as ee } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { vLoading as te } from "element-plus";
import { c as ae, s as ie, g as ne } from "./module/change-table.vue.js";
import { _ as re, x as le, nj as se, o as pe, a3 as I, aU as ce, D as M, P as ue } from "../../../../shared/runtime.js";
import { u as de } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as me } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as fe } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import we from "./module/header.vue.js";
import ye from "./module/form.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const be = { class: "app-container" }, he = { class: "head-container" }, _e = { style: { display: "inline-block" } }, ge = ["onDblclick"], ve = { __name: "index", setup(Se) {
  const W = { add: false, edit: false, del: false, download: false }, T = w(), g = w([]), v = w([]), { crud: t, CRUD: j, columns: p } = le({ title: "构件规格修正", sort: ["id.asc"], permission: { ...se }, optShow: { ...W }, crudApi: { ...ae }, hasPagination: true }, T), { maxHeight: H } = pe({ paginate: true, extraHeight: 40 });
  O(), x([() => t.query.projectId, () => t.query.boolAmendStatus, () => t.query.monomerId, () => t.query.areaId, () => t.query.serialNumber, () => t.query.name, () => t.query.oldSpecification, () => t.query.newSpecification], (a) => {
    t.query.specification = void 0, $();
  }), P("specList", g.value), P("specificationList", v);
  const { showDrawing: S, drawingRow: n, drawingPreview: U } = de({ pidField: "artifactId", typeField: "productType" }), h = w(false), _ = w(false);
  x([() => h.value, () => _.value], ([a, o]) => {
    !a && !o && (S.value = false), console.log(a, o, S.value, "show");
  }), x(() => S.value, (a) => {
    var o, i, u, f;
    a && ((o = n.value) != null && o.productType && ((i = n.value) == null ? void 0 : i.productType) & I.ARTIFACT.V && (h.value = true), (u = n.value) != null && u.productType && !(((f = n.value) == null ? void 0 : f.productType) & I.ARTIFACT.V) && (_.value = true));
  });
  async function O() {
    g.value = [];
    try {
      const { content: a } = await ie({ productionLineTypeEnum: ce.TRADITION.V });
      for (let o = 0; o < a.length; o++) g.value.push({ id: a[o], value: a[o] });
    } catch (a) {
      console.log("获取构件截面定义", a);
    }
  }
  async function $() {
    v.value = [];
    try {
      const a = await ne({ boolAmendStatus: t.query.boolAmendStatus, monomerId: t.query.monomerId, areaId: t.query.areaId, projectId: t.query.projectId, oldSpecification: t.query.oldSpecification, newSpecification: t.query.newSpecification, name: t.query.name, serialNumber: t.query.serialNumber });
      for (let o = 0; o < (a == null ? void 0 : a.length); o++) v.value.push({ id: a[o], name: a[o] });
    } catch (a) {
      console.log("获取规格列表失败", a);
    }
  }
  return j.HOOK.handleRefresh = (a, o) => {
    var i;
    o.data.content = (i = o.data) == null ? void 0 : i.content.map((u) => {
      var f;
      return u.productType = I.ARTIFACT.V, u.monomerId = (f = u.monomer) == null ? void 0 : f.id, u;
    });
  }, (a, o) => {
    var q, C, N, k, D, A, R, V, E, F, L;
    const i = Y, u = Z, f = ee, K = oe, G = J("common-table"), z = te;
    return l(), Q("div", be, [y("div", he, [d(e(we))]), X((l(), s(G, { ref_key: "tableRef", ref: T, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(H), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSelectionChange: e(t).selectionChangeHandler, onSortChange: e(t).handleSortChange }, { default: m(() => [d(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(p).visible("monomer.name") ? (l(), s(i, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100px" })) : c("", true), e(p).visible("area.name") ? (l(), s(i, { key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px" })) : c("", true), e(p).visible("name") ? (l(), s(i, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100px" })) : c("", true), e(p).visible("serialNumber") ? (l(), s(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { header: m(() => [d(K, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: m(() => [y("div", _e, [o[2] || (o[2] = y("span", { style: { "margin-left": "10px" } }, "编号", -1)), d(f, null, { default: m(() => [d(u)]), _: 1 })])]), _: 1 })]), default: m((r) => [y("span", { style: { cursor: "pointer" }, onDblclick: (xe) => e(U)(r.row), class: "tc-primary" }, b(r.row.serialNumber), 41, ge)]), _: 1 })) : c("", true), e(p).visible("oldSpecification") ? (l(), s(i, { key: "oldSpecification", prop: "oldSpecification", "show-overflow-tooltip": true, label: e(t).query.boolAmendStatus ? "旧规格" : "规格", "min-width": "120" }, null, 8, ["label"])) : c("", true), e(p).visible("newSpecification") ? (l(), s(i, { key: "newSpecification", prop: "newSpecification", "show-overflow-tooltip": true, label: "新规格", "min-width": "120" }, { default: m((r) => [y("span", null, b(r.row.newSpecPrefix) + b(r.row.newSpecification || "-"), 1)]), _: 1 })) : c("", true), e(p).visible("length") ? (l(), s(i, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", align: "left", "min-width": "85px" }, { default: m((r) => [B(b(r.row.length ? r.row.length.toFixed(e(M).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : c("", true), e(p).visible("material") ? (l(), s(i, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "left", "min-width": "80px" })) : c("", true), e(p).visible("quantity") ? (l(), s(i, { key: "quantity", prop: "quantity", label: "清单数", align: "left", "min-width": "80px" })) : c("", true), e(p).visible("netWeight") ? (l(), s(i, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单净重(kg)", align: "left", "min-width": "80px" }, { default: m((r) => [B(b(r.row.netWeight ? r.row.netWeight.toFixed(e(M).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange", "onSortChange"])), [[z, e(t).loading]]), d(e(ue)), d(e(ye)), d(e(me), { visible: h.value, "onUpdate:visible": o[0] || (o[0] = (r) => h.value = r), "bool-bim": (q = e(n)) == null ? void 0 : q.boolBim, drawingSN: (C = e(n)) == null ? void 0 : C.drawingSN, "monomer-id": (N = e(n)) == null ? void 0 : N.monomerId, "area-id": e(t).query.areaId, "serial-number": (k = e(n)) == null ? void 0 : k.serialNumber, productId: (D = e(n)) == null ? void 0 : D.productId, productType: (A = e(n)) == null ? void 0 : A.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType"]), d(e(fe), { modelValue: _.value, "onUpdate:modelValue": o[1] || (o[1] = (r) => _.value = r), drawingSN: (R = e(n)) == null ? void 0 : R.drawingSN, "bool-bim": (V = e(n)) == null ? void 0 : V.boolBim, "serial-number": (E = e(n)) == null ? void 0 : E.serialNumber, productId: (F = e(n)) == null ? void 0 : F.productId, productType: (L = e(n)) == null ? void 0 : L.productType }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType"])]);
  };
} }, Be = re(ve, [["__scopeId", "data-v-4a64a99b"]]);
export {
  Be as default
};
