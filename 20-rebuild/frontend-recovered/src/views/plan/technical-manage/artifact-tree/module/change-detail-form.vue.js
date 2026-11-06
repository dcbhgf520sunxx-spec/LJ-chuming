import { ref as k } from "vue";
import { watch as U } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as r } from "vue";
import { unref as t } from "vue";
import { createElementVNode as C } from "vue";
import { withDirectives as $ } from "vue";
import { createElementBlock as h } from "vue";
import { isRef as J } from "vue";
import { nextTick as Q } from "vue";
import { ElDescriptionsItem as X } from "element-plus";
import { ElDescriptions as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { u as te } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ae, u as le, o as oe, z as re, D as _, b as ne, i as g, ai as b, a3 as V } from "../../../../../shared/runtime.js";
import { _ as p } from "../../../../../modules/index-61ce89a1.js";
const ie = { key: 0 }, se = { key: 1, class: "child" }, de = { style: { cursor: "pointer", "margin-left": "10px" } }, ue = { key: 1 }, we = { key: 1 }, me = { key: 1 }, ce = { key: 1 }, he = { key: 1 }, fe = { key: 1 }, _e = { key: 1 }, ge = { key: 1 }, be = { __name: "change-detail-form", props: { modelValue: { type: Boolean, require: true }, editList: { type: Array, default: () => [] }, currentRow: { type: Object, default: () => {
} }, uploadList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(m, { emit: F }) {
  const v = F, f = m, { visible: W, handleClose: T } = le({ emit: v, props: f }), R = k([]), A = k(), G = k(false), x = k(), E = k(), I = k([]), L = k([]);
  U(W, (s) => {
    s && (R.value = [], x.value = void 0, S(), console.log(f.currentRow, f.uploadList), L.value = f.uploadList.filter((n) => n.structureClassId === f.currentRow.structureClassId) || []);
  }, { immediate: true, deep: true });
  function q(s) {
    v("deleteModifyItem", s);
  }
  const { maxHeight: B } = oe({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, A);
  function M(s) {
    return s.children ? s.index : s.childIndex;
  }
  function D() {
    const s = [];
    f.editList.forEach((n) => {
      s.push({ artifactId: n.artifactId, changeSerialNumber: x.value, sortNumber: n.sortNumber });
    }), v("success", s), T();
  }
  function O(s) {
    var n;
    if (s) {
      const d = ((n = L.value) == null ? void 0 : n.find((w) => w.serialNumber === s)) || {};
      if (d.productType = V.ARTIFACT.V, d.dataType = 2, d.index = 1, d.machinePartList && d.machinePartList.length > 0) {
        let w = 1;
        d.machinePartList.map((y) => {
          var o;
          y.dataType = 1, y.childIndex = w, w++, y.productType = V.MACHINE_PART.V, y.oldPart = ((o = I.value) == null ? void 0 : o.find((P) => P.serialNumber === y.serialNumber)) || {};
        });
      }
      d.children = d.machinePartList, Q(() => {
        R.value = [d];
      });
    }
  }
  async function S() {
    var n;
    let s = [];
    try {
      const { content: d = [] } = await te({ monomerId: (n = f.currentRow.monomer) == null ? void 0 : n.id, serialNumber: f.currentRow.serialNumber });
      s = d;
    } catch (d) {
      console.log("获取构件原零件明细失败", d);
    } finally {
      I.value = s;
    }
  }
  return (s, n) => {
    const d = N("common-button"), w = X, y = Y, o = Z, P = N("common-table"), H = N("common-select"), j = N("table-cell-tag"), z = N("common-drawer"), K = ee;
    return i(), c(z, { ref_key: "drawerRef", ref: A, title: "变更操作", "close-on-click-modal": false, modelValue: t(W), "onUpdate:modelValue": n[1] || (n[1] = (e) => J(W) ? W.value = e : null), direction: "rtl", "before-close": t(T), "custom-class": "inbound-record", size: "90%" }, { titleRight: l(() => [a(d, { class: "filter-item", size: "default", type: "primary", onClick: D, disabled: !x.value }, { default: l(() => n[2] || (n[2] = [u("保存变更")])), _: 1, __: [2] }, 8, ["disabled"])]), content: l(() => [a(y, { class: "margin-top", column: 4, border: "" }, { default: l(() => [a(w, { "label-class-name": "contractLabel", label: "项目" }, { default: l(() => [u(r(t(re)(m.currentRow.project)), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "单体" }, { default: l(() => [u(r(m.currentRow.monomer.name), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "编号", span: 2 }, { default: l(() => [u(r(m.currentRow.serialNumber), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "规格" }, { default: l(() => [u(r(m.currentRow.specification), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "材质" }, { default: l(() => [u(r(m.currentRow.material), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "单净重(kg)" }, { default: l(() => [u(r(m.currentRow.netWeight ? m.currentRow.netWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 }), a(w, { "label-class-name": "contractLabel", label: "长度(mm)" }, { default: l(() => [u(r(m.currentRow.length ? m.currentRow.length.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })]), _: 1 }), a(P, { data: m.editList, "return-source-data": "", "max-height": 400, style: { width: "100%", margin: "20px 0" } }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": "", label: "区域", "min-width": "140px" }), a(o, { key: "sortNumber", prop: "sortNumber", "show-overflow-tooltip": "", label: "流水号", "min-width": "120" }, { default: l((e) => [u(r(e.row.sortNumber ? e.row.serialNumber + "(" + e.row.sortNumber + ")" : "-"), 1)]), _: 1 }), a(o, { key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": "", label: "产线", align: "left", "min-width": "80px" }), a(o, { key: "status", prop: "status", "show-overflow-tooltip": "", label: "当前状态", align: "left", "min-width": "80px" }, { default: l((e) => [u(r(e.row.status ? e.row.status : "-"), 1)]), _: 1 }), a(o, { label: "操作", width: "120", align: "center", fixed: "right" }, { default: l((e) => [a(d, { type: "danger", size: "default", onClick: (pe) => q(e.row) }, { default: l(() => n[3] || (n[3] = [u("剔除")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"]), n[4] || (n[4] = C("span", { class: "el-form-item__label" }, [C("span", { style: { color: "red" } }, "*"), u("变更清单引用")], -1)), a(H, { modelValue: x.value, "onUpdate:modelValue": n[0] || (n[0] = (e) => x.value = e), options: L.value, type: "other", dataStructure: { key: "serialNumber", label: "serialNumber", value: "serialNumber" }, size: "default", clearable: "", placeholder: "请选择变更清单的编号", class: "filter-item", style: { width: "200px" }, onChange: O }, null, 8, ["modelValue", "options"]), $((i(), c(P, { ref_key: "serialNumberRef", ref: E, data: R.value, "return-source-data": "", "max-height": t(B) - 80, "show-empty-symbol": false, "row-key": "serialNumber", style: { "margin-top": "20px" }, "default-expand-all": "" }, { default: l(() => [a(o, { prop: "index", label: "序号", align: "center", width: "80" }, { default: l((e) => [e.row.children ? (i(), h("span", ie, r(M(e.row)), 1)) : (i(), h("span", se, r(M(e.row)), 1))]), _: 1 }), a(o, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", "min-width": "100px" }), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", "min-width": "140px" }, { default: l((e) => [a(j, { show: e.row.dataType !== 2 && t(ne)(e.row.oldPart), name: "新增" }, null, 8, ["show"]), C("span", de, r(e.row.serialNumber), 1)]), _: 1 }), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "120" }, { default: l((e) => [u(r(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 }), a(o, { key: "length", prop: "length", "show-overflow-tooltip": "", label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.length, e.row.oldPart.length) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.length, new: e.row.length }, null, 8, ["old", "new"])) : (i(), h("span", ue, r(e.row.length ? e.row.length.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1))]), _: 1 }), a(o, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "80px" }, { default: l((e) => [u(r(e.row.material ? e.row.material : "-"), 1)]), _: 1 }), a(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "left", "min-width": "80px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.quantity, e.row.oldPart.quantity) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.quantity, new: e.row.quantity }, null, 8, ["old", "new"])) : (i(), h("span", we, r(e.row.quantity ? e.row.quantity : "-"), 1))]), _: 1 }), a(o, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.netWeight, e.row.oldPart.netWeight) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.netWeight, new: e.row.netWeight }, null, 8, ["old", "new"])) : (i(), h("span", me, r(e.row.netWeight ? e.row.netWeight.toFixed(t(_).COM_WT__KG) : "-"), 1))]), _: 1 }), a(o, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": "", label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.grossWeight, e.row.oldPart.grossWeight) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.grossWeight, new: e.row.grossWeight }, null, 8, ["old", "new"])) : (i(), h("span", ce, r(e.row.grossWeight ? e.row.grossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1))]), _: 1 }), a(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: `总净重
(kg)`, align: "left", "min-width": "95px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.totalNetWeight, e.row.oldPart.totalNetWeight) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.totalNetWeight, new: e.row.totalNetWeight }, null, 8, ["old", "new"])) : (i(), h("span", he, r(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(t(_).COM_WT__KG) : "-"), 1))]), _: 1 }), a(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": "", label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.totalGrossWeight, e.row.oldPart.totalGrossWeight) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.totalGrossWeight, new: e.row.totalGrossWeight }, null, 8, ["old", "new"])) : (i(), h("span", fe, r(e.row.totalGrossWeight ? e.row.totalGrossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1))]), _: 1 }), a(o, { key: "surfaceArea", prop: "surfaceArea", "show-overflow-tooltip": "", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.surfaceArea, e.row.oldPart.surfaceArea) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.surfaceArea, new: e.row.surfaceArea }, null, 8, ["old", "new"])) : (i(), h("span", _e, r(e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(_).COM_AREA__M2) : "-"), 1))]), _: 1 }), a(o, { key: "drawingNumber", prop: "drawingNumber", "show-overflow-tooltip": "", label: "图号", "min-width": "100px" }, { default: l((e) => [t(g)(e.row.oldPart) && !t(b)(e.row.drawingNumber, e.row.oldPart.drawingNumber) ? (i(), c(t(p), { key: 0, old: e.row.oldPart.drawingNumber, new: e.row.drawingNumber }, null, 8, ["old", "new"])) : (i(), h("span", ge, r(e.row.drawingNumber || "-"), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[K, G.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, We = ae(be, [["__scopeId", "data-v-6c974921"]]);
export {
  We as default
};
