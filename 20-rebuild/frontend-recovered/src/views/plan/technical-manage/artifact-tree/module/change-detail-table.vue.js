import { ref as u } from "vue";
import { inject as de } from "vue";
import { computed as V } from "vue";
import { watch as me } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as w } from "vue";
import { createBlock as A } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as d } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as y } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as Q } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as P } from "vue";
import { isRef as ce } from "vue";
import { ElMessage as G } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElBadge as pe } from "element-plus";
import { vLoading as be } from "element-plus";
import { t as ye, m as he } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ge, u as we, i as h, o as ve, tx as _e } from "../../../../../shared/runtime.js";
import { u as xe } from "../../../../../modules/use-production-team-d8043fd6.js";
import { _ as Ne } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import Ie from "./change-detail-form.vue.js";
import ke from "./change-confirm-form.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "../../../../../modules/change-reason-select-73e53277.js";
const Ae = { key: 0, style: { "font-size": "16px", color: "green" } }, Ce = { key: 1, style: { "font-size": "12px", color: "red" } }, Se = { style: { display: "flex" } }, Le = { style: { flex: "1" } }, Ee = { style: { width: "700px" } }, Te = { class: "head-container clearfix" }, Be = { style: { float: "right" } }, Ve = { __name: "change-detail-table", props: { modelValue: { type: Boolean, require: true }, submitList: { type: Array, default: () => [] }, totalArea: { type: Array, default: () => [] }, type: { type: [Number, String], default: void 0 }, areaBatchId: { type: [Number, String] } }, emits: ["update:modelValue", "success"], setup(x, { emit: J }) {
  const U = J, D = x, { visible: C, handleClose: H } = we({ emit: U, props: D }), { loaded: W, productionTeam: X } = xe(), N = u({}), Y = de("searchQuery"), I = u([]), K = u(), S = u(false), c = u({}), g = u([]), m = u([]), L = u(false), Z = u(), E = u([]), R = u(), z = u(false), q = u(false), $ = u(), ee = V(() => X.value.filter((t) => {
    var e, i;
    return ((e = c.value) == null ? void 0 : e.productType) & t.productType && ((i = c.value) == null ? void 0 : i.productionLineTypeEnum) & t.productionLineTypeEnum;
  })), te = V(() => !g.value.filter((e) => h(e.deleteArr) || h(e.modifyArr)).length), ae = V(() => {
    const t = [];
    return g.value.forEach((e) => {
      (h(e.modifyArr) || h(e.deleteArr)) && t.push(e);
    }), t;
  }), le = V(() => ({ artifactIds: c.value.artifactIds, ...N.value }));
  me(C, (t) => {
    var e;
    t && (L.value = false, E.value = [], R.value = void 0, I.value = [], g.value = (e = D.submitList) == null ? void 0 : e.map((i) => ({ ...i, deleteArr: [], modifyArr: [] })));
  }, { immediate: true });
  const { maxHeight: j } = ve({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, K);
  function oe(t, e) {
    return t.boolStatusEnum && t.boolCargo && !t.isEdit;
  }
  function re({ row: t, rowIndex: e }) {
    return h(t.modifyArr) || h(t.deleteArr) ? "abnormal-row" : "";
  }
  function ie(t) {
    if (t.code === 2e4) {
      G.success("上传成功");
      const e = t == null ? void 0 : t.data;
      E.value = (e == null ? void 0 : e.artifactList) || [], R.value = e == null ? void 0 : e.redisKey, L.value = true;
    } else G.error(t.message);
  }
  function ne(t) {
    m.value = [], t.map((e) => {
      m.value.push(e);
    });
  }
  function F(t, e) {
    var p, b, v;
    const i = m.value.findIndex((s) => s.artifactId === t.artifactId && s.sortNumber === t.sortNumber), o = I.value.find((s) => s.artifactId === t.artifactId && s.sortNumber === t.sortNumber) || {};
    e || (p = $.value) == null || p.toggleRowSelection(t), o.isEdit = false, m.value.splice(i, 1);
    const r = g.value.find((s) => s.artifactIds.includes(t.artifactId)) || {};
    ((b = r == null ? void 0 : r.modifyArr) == null ? void 0 : b.findIndex((s) => s.artifactId === t.artifactId && s.sortNumber === t.sortNumber)) > -1 && (r == null || r.modifyArr.splice((v = r == null ? void 0 : r.modifyArr) == null ? void 0 : v.findIndex((s) => s.artifactId === t.artifactId && s.sortNumber === t.sortNumber), 1));
  }
  function se(t) {
    var o;
    m.value.map((r) => {
      r.isEdit = true;
    });
    const e = g.value.find((r) => r.artifactIds.includes(t[0].artifactId)) || {}, i = [];
    t.forEach((r) => {
      var p;
      if ((e == null ? void 0 : e.modifyArr.findIndex((b) => b.sortNumber === r.sortNumber)) < 0) e == null || e.modifyArr.push(r);
      else {
        const b = (p = e.modifyArr) == null ? void 0 : p.findIndex((v) => v.sortNumber === r.sortNumber);
        e.modifyArr[b] = r;
      }
    }), h(e == null ? void 0 : e.modifyArr) && (e == null || e.modifyArr.map((r) => {
      i.includes(r.changeSerialNumber) || i.push(r.changeSerialNumber);
    })), e.changeSerialNumberName = i.join("、"), (o = $.value) == null || o.clearSelection(), m.value = [];
  }
  async function T(t) {
    let e = [];
    S.value = true, c.value = t, m.value = [];
    try {
      const { content: i = [] } = await he({ ...le.value });
      i.map((o) => {
        o.material = c.value.material;
      }), e = i;
    } catch (i) {
      console.log("获取构件详情失败", i);
    } finally {
      I.value = e, console.log(I.value), S.value = false;
    }
  }
  function ue() {
    var t;
    T(c.value), g.value = (t = D.submitList) == null ? void 0 : t.map((e) => ({ ...e, deleteArr: [], modifyArr: [] })), H(), U("success");
  }
  return (t, e) => {
    const i = k("common-button"), o = fe, r = k("common-table"), p = k("common-select"), b = pe, v = k("table-cell-tag"), s = k("common-drawer"), O = be;
    return w(), A(s, { ref_key: "drawerRef", ref: K, title: "构件变更", "close-on-click-modal": false, modelValue: d(C), "onUpdate:modelValue": e[8] || (e[8] = (a) => ce(C) ? C.value = a : null), direction: "rtl", "before-close": d(H), "custom-class": "inbound-record", size: "100%" }, { titleAfter: n(() => [l(d(Ne), { ref_key: "uploadRef", ref: Z, data: { monomerId: d(Y).monomerId }, "upload-fun": d(ye), "btn-name": L.value ? "重新导入新清单" : "导入新清单", "btn-type": "success", "btn-size": "default", "show-file-list": false, onSuccess: ie }, null, 8, ["data", "upload-fun", "btn-name"]), L.value ? (w(), M("span", Ae, "✔")) : (w(), M("span", Ce, "*提示：请先导变更后新清单"))]), content: n(() => [y("div", Se, [y("div", Le, [y("div", null, [l(i, { size: "default", type: "primary", onClick: e[0] || (e[0] = (a) => q.value = true), disabled: te.value, style: { float: "right", "margin-bottom": "10px" } }, { default: n(() => e[9] || (e[9] = [f("变更确认")])), _: 1, __: [9] }, 8, ["disabled"])]), Q((w(), A(r, { data: g.value, "return-source-data": "", "max-height": d(j) - 50, "cell-class-name": re }, { default: n(() => [l(o, { type: "index", label: "序号", align: "center", width: "80" }), l(o, { label: "构件基础信息", align: "center" }, { default: n(() => [l(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "构件编号", "min-width": "140px" }), l(o, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "120" }, { default: n((a) => [f(_(a.row.specification ? a.row.specification : "-"), 1)]), _: 1 }), l(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "清单数", align: "left", "min-width": "80px" }, { default: n((a) => [f(_(a.row.quantity ? a.row.quantity : "-"), 1)]), _: 1 }), l(o, { label: "操作", width: "85", align: "center", fixed: "right" }, { default: n((a) => [l(i, { type: "warning", size: "default", onClick: (B) => T(a.row) }, { default: n(() => e[10] || (e[10] = [f("变更")])), _: 2, __: [10] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }), l(o, { label: "变更后信息", align: "center" }, { default: n(() => [l(o, { key: "changeSerialNumberName", prop: "changeSerialNumberName", "show-overflow-tooltip": "", label: "编号", "min-width": "140px" }), l(o, { key: "changeNum", prop: "changeNum", "show-overflow-tooltip": "", label: "变更", "min-width": "120" }, { default: n((a) => [f(_(d(h)(a.row.modifyArr) ? a.row.modifyArr.length : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[O, S.value]])]), e[13] || (e[13] = y("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), y("div", Ee, [y("div", Te, [x.type === d(_e).MONOMER.V ? (w(), A(p, { key: 0, modelValue: N.value.areaId, "onUpdate:modelValue": e[1] || (e[1] = (a) => N.value.areaId = a), options: x.totalArea, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "200px" }, onChange: e[2] || (e[2] = (a) => T(c.value)) }, null, 8, ["modelValue", "options"])) : P("", true), l(p, { modelValue: N.value.groupIds, "onUpdate:modelValue": e[3] || (e[3] = (a) => N.value.groupIds = a), options: ee.value, multiple: "", type: "other", dataStructure: { key: "id", label: "label", value: "id" }, size: "default", clearable: "", placeholder: "请选择班组", class: "filter-item", disabled: !d(W), style: { width: "200px" }, onChange: e[4] || (e[4] = (a) => T(c.value)) }, null, 8, ["modelValue", "options", "disabled"]), y("span", Be, [l(b, { value: m.value.length, hidden: m.value.length <= 0 }, { default: n(() => [l(i, { class: "filter-item", size: "default", type: "success", onClick: e[5] || (e[5] = (a) => z.value = true), disabled: E.value.length === 0 || m.value.length === 0 }, { default: n(() => e[11] || (e[11] = [f("变更预览")])), _: 1, __: [11] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])])]), Q((w(), A(r, { ref_key: "modifyTable", ref: $, data: I.value, "return-source-data": "", "max-height": d(j) - 50, style: { width: "100%" }, onSelectionChange: ne }, { default: n(() => [l(o, { label: "生产信息", align: "center" }, { default: n(() => [l(o, { key: "selection", type: "selection", width: "55", selectable: oe }), l(o, { type: "index", label: "序号", align: "center", width: "80" }), l(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": "", label: "区域", "min-width": "140px" }, { default: n((a) => {
      var B;
      return [a.row.isDelete || a.row.isEdit ? (w(), A(v, { key: 0, name: a.row.isDelete ? "删除" : a.row.isEdit ? "修改" : "", color: a.row.isDelete ? "#f56c6c" : a.row.isEdit ? "#67c23a" : "", offset: 15 }, null, 8, ["name", "color"])) : P("", true), y("span", null, _((B = a.row.area) == null ? void 0 : B.name), 1)];
    }), _: 1 }), l(o, { key: "sortNumber", prop: "sortNumber", "show-overflow-tooltip": "", label: "流水号", "min-width": "120" }, { default: n((a) => [f(_(a.row.sortNumber ? a.row.serialNumber + "(" + a.row.sortNumber + ")" : "-"), 1)]), _: 1 }), l(o, { key: "team.name", prop: "team.name", "show-overflow-tooltip": "", label: "班组", align: "left", "min-width": "80px" }), l(o, { key: "status", prop: "status", "show-overflow-tooltip": "", label: "当前状态", align: "left", "min-width": "80px" }, { default: n((a) => [f(_(a.row.status ? a.row.status : "-"), 1)]), _: 1 }), l(o, { label: "操作", width: "150", align: "center", fixed: "right" }, { default: n((a) => [l(i, { type: "info", size: "default", onClick: (B) => F(a.row, 1), disabled: !a.row.isEdit }, { default: n(() => e[12] || (e[12] = [f("撤销修改")])), _: 2, __: [12] }, 1032, ["onClick", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[O, S.value]])])]), l(d(Ie), { modelValue: z.value, "onUpdate:modelValue": e[6] || (e[6] = (a) => z.value = a), editList: m.value, onDeleteModifyItem: F, currentRow: c.value, uploadList: E.value, onSuccess: se }, null, 8, ["modelValue", "editList", "currentRow", "uploadList"]), l(d(ke), { modelValue: q.value, "onUpdate:modelValue": e[7] || (e[7] = (a) => q.value = a), areaBatchId: x.areaBatchId, confirmList: ae.value, type: x.type, redisKey: R.value, onSuccess: ue }, null, 8, ["modelValue", "areaBatchId", "confirmList", "type", "redisKey"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Fe = ge(Ve, [["__scopeId", "data-v-e350a5c2"]]);
export {
  Fe as default
};
