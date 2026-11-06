import { ref as c } from "vue";
import { inject as ae } from "vue";
import { computed as oe } from "vue";
import { watch as le } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as j } from "vue";
import { createBlock as q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as R } from "vue";
import { withModifiers as S } from "vue";
import { withDirectives as ie } from "vue";
import { unref as i } from "vue";
import { isRef as re } from "vue";
import { ElTag as ne } from "element-plus";
import { ElBadge as se } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElPagination as me } from "element-plus";
import { vLoading as pe } from "element-plus";
import { p as ce } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { u as fe, J as he, tx as C, o as ge, D as f, z as we, a3 as _e } from "../../../../../shared/runtime.js";
import be from "./change-detail-table.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/ExcelUploadBtn-acccae97.js";
import "./change-detail-form.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "./change-confirm-form.vue.js";
import "../../../../../modules/change-reason-select-73e53277.js";
const ye = { class: "head-container" }, xe = { style: { cursor: "pointer", "margin-left": "10px" } }, ze = { __name: "change-table", props: { modelValue: { type: Boolean, require: true }, type: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "success"], setup(V, { emit: L }) {
  const W = L, h = V, { visible: b, handleClose: E } = fe({ emit: W, props: h }), { handleSizeChange: F, handleCurrentChange: G, total: D, setTotalPage: H, queryPage: N } = he({ fetchHook: w }), y = c({}), u = ae("searchQuery"), k = c(false), m = c([]), O = oe(() => {
    let o = {};
    return Number(h.type) === C.AREA.V ? o = { projectId: u.projectId, monomerId: u.monomerId, areaId: u.areaId } : Number(h.type) === C.MONOMER.V ? o = { projectId: u.projectId, monomerId: u.monomerId } : Number(h.type) === C.AREA_BATCH.V && (o = { projectId: u.projectId, monomerId: u.monomerId, areaBatchId: u.areaBatchId }), { ...o, ...y.value };
  });
  le(b, (o) => {
    o && (m.value = [], T.value = [], w());
  }, { immediate: true, deep: true });
  const g = c([]), z = c(), A = c(false), T = c([]), x = c([]);
  function P(o) {
    m.value.findIndex((t) => t.id === o.id) < 0 && m.value.push(o);
  }
  function K(o) {
    if (m.value.findIndex((t) => t.id === o.id) > -1) {
      const t = m.value.findIndex((n) => n.id === o.id);
      m.value.splice(t, 1);
    }
  }
  const { maxHeight: U } = ge({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, z);
  function $() {
    y.value = {}, w();
  }
  function Q() {
    const o = [];
    x.value = [], m.value.forEach((t) => {
      if (x.value.findIndex((n) => {
        var d;
        return n.id === ((d = t.area) == null ? void 0 : d.id);
      }) < 0 && x.value.push(t.area), o.findIndex((n) => n.serialNumber === t.serialNumber) < 0) o.push({ project: t.project, monomer: t.monomer, productType: _e.ARTIFACT.V, productionLineTypeEnum: t.productionLineTypeEnum, area: [t.area], serialNumber: t.serialNumber, specification: t.specification, material: t.material, quantity: t.quantity, artifactIds: [t.id], netWeight: t.netWeight, length: t.length, structureClassId: t.structureClassId });
      else {
        const n = o.find((d) => d.serialNumber === t.serialNumber);
        n.artifactIds.includes(t.id) || (n.quantity += t.quantity, n.artifactIds.push(t.id)), n.area.findIndex((d) => {
          var v;
          return d.id === ((v = d.area) == null ? void 0 : v.id);
        }) < 0 && n.area.push(t.area);
      }
    }), T.value = o, k.value = true;
  }
  async function w() {
    let o = [];
    if (!u.projectId || !u.monomerId || Number(h.type) === C.AREA.V && !u.areaId) {
      g.value = [];
      return;
    }
    A.value = true;
    try {
      const { content: t = [], totalElements: n } = await ce({ ...O.value, ...N });
      o = t, H(n);
    } catch (t) {
      console.log("获取构件列表失败", t);
    } finally {
      g.value = o, A.value = false;
    }
  }
  function J() {
    w(), E(), W("success");
  }
  return (o, t) => {
    var M;
    const n = ne, d = I("common-button"), v = se, X = de, r = ue, B = I("table-cell-tag"), Y = I("common-table"), Z = me, ee = I("common-drawer"), te = pe;
    return j(), q(ee, { ref_key: "drawerRef", ref: z, title: `项目:${i(we)((M = g.value[0]) == null ? void 0 : M.project)}`, "close-on-click-modal": false, modelValue: i(b), "onUpdate:modelValue": t[2] || (t[2] = (e) => re(b) ? b.value = e : null), direction: "rtl", "before-close": i(E), "custom-class": "inbound-record", size: "90%" }, { titleAfter: l(() => [a(n, { effect: "plain", size: "medium" }, { default: l(() => {
      var e;
      return [s("单体：" + p((e = g.value[0]) == null ? void 0 : e.monomer.name), 1)];
    }), _: 1 })]), titleRight: l(() => [a(v, { value: m.value.length, hidden: m.value.length <= 0 }, { default: l(() => [a(d, { class: "filter-item", size: "default", type: "primary", onClick: Q, disabled: m.value.length <= 0 }, { default: l(() => t[3] || (t[3] = [s("变更列表预览")])), _: 1, __: [3] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])]), content: l(() => [R("div", ye, [a(X, { modelValue: y.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (e) => y.value.serialNumber = e), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), a(d, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: S(w, ["stop"]) }, { default: l(() => t[4] || (t[4] = [s("搜索")])), _: 1, __: [4] }), a(d, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: S($, ["stop"]) }, { default: l(() => t[5] || (t[5] = [s("重置")])), _: 1, __: [5] })]), ie((j(), q(Y, { data: g.value, "return-source-data": "", "max-height": i(U) - 80 }, { default: l(() => [a(r, { label: "序号", type: "index", align: "center", width: "60" }), a(r, { key: "area.name", prop: "area.name", "show-overflow-tooltip": "", label: "区域", "min-width": "100px" }), a(r, { key: "areaBatchName", prop: "areaBatchName", align: "center", "show-overflow-tooltip": "", label: "批次", "min-width": "140px" }), a(r, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", "min-width": "100px" }), a(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", "min-width": "140px" }, { default: l((e) => [a(B, { show: e.row.dataType !== 2 && e.row.boolSendDirectly, name: "直发件" }, null, 8, ["show"]), a(B, { show: e.row.dataType !== 2 && e.row.relationType === 8, name: "配套件" }, null, 8, ["show"]), R("span", xe, p(e.row.serialNumber), 1)]), _: 1 }), a(r, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "120" }, { default: l((e) => [s(p(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 }), a(r, { key: "length", prop: "length", "show-overflow-tooltip": "", label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: l((e) => [s(p(e.row.length ? e.row.length.toFixed(i(f).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 }), a(r, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "80px" }, { default: l((e) => [s(p(e.row.material ? e.row.material : "-"), 1)]), _: 1 }), a(r, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "left", "min-width": "80px" }, { default: l((e) => [s(p(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 }), a(r, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: l((e) => [s(p(e.row.netWeight ? e.row.netWeight.toFixed(i(f).COM_WT__KG) : "-"), 1)]), _: 1 }), a(r, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": "", label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: l((e) => [s(p(e.row.grossWeight ? e.row.grossWeight.toFixed(i(f).COM_WT__KG) : "-"), 1)]), _: 1 }), a(r, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: `总净重
(kg)`, align: "left", "min-width": "95px" }, { default: l((e) => [s(p(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(i(f).COM_WT__KG) : "-"), 1)]), _: 1 }), a(r, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": "", label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: l((e) => [s(p(e.row.totalGrossWeight ? e.row.totalGrossWeight.toFixed(i(f).COM_WT__KG) : "-"), 1)]), _: 1 }), a(r, { key: "surfaceArea", prop: "surfaceArea", "show-overflow-tooltip": "", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: l((e) => [s(p(e.row.surfaceArea ? e.row.surfaceArea.toFixed(i(f).COM_AREA__M2) : "-"), 1)]), _: 1 }), a(r, { key: "drawingNumber", prop: "drawingNumber", "show-overflow-tooltip": "", label: "图号", "min-width": "100px" }, { default: l((e) => [s(p(e.row.drawingNumber ? e.row.drawingNumber : "-"), 1)]), _: 1 }), a(r, { label: "操作", width: "120", align: "center", fixed: "right" }, { default: l((e) => [a(d, { type: "primary", icon: "el-icon-plus", disabled: m.value.findIndex((_) => _.id === e.row.id) > -1 || !e.row.boolStatusEnum || !e.row.structureClassId, size: "default", onClick: (_) => P(e.row) }, null, 8, ["disabled", "onClick"]), a(d, { type: "danger", icon: "el-icon-delete", disabled: !(m.value.findIndex((_) => _.id === e.row.id) > -1), size: "default", onClick: (_) => K(e.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[te, A.value]]), a(Z, { total: i(D), "current-page": i(N).pageNumber, "page-size": i(N).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(F), onCurrentChange: i(G) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(i(be), { modelValue: k.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => k.value = e), areaBatchId: i(u).areaBatchId, submitList: T.value, type: V.type, onSuccess: J, totalArea: x.value }, null, 8, ["modelValue", "areaBatchId", "submitList", "type", "totalArea"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ze as default
};
