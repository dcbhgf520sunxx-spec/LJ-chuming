import { ref as f } from "vue";
import { provide as G } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as c } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as J } from "vue";
import { renderList as W } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTag as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as te, x as ae, o as ne, iE as L, gD as oe, bN as ie, G as le, P as re, i as R, a as se } from "../../../shared/runtime.js";
import { c as ce, _ as ue } from "./module/import-dialog.vue.js";
import pe from "./module/header.vue.js";
import de from "./module/detail.vue.js";
import { l as g } from "../../../modules/contract-9b18cc88.js";
import "./module/not-archived-list-drawer.vue.js";
const me = { class: "app-container" }, fe = { class: "head-container" }, ve = { style: { padding: "20px 30px" } }, _e = ["onClick"], he = ["onClick"], we = { class: "tc-success" }, be = { class: "tc-danger" }, ye = { __name: "index", setup(ge) {
  const A = f([]);
  G("permission", g);
  const B = { add: false, edit: false, del: true, download: false }, D = f(), x = f(false), I = { TRUE: { L: "已归档", K: "TRUE", V: 1 }, FALSE: { L: "未归档", K: "FALSE", V: 0 } }, { crud: v, columns: d } = ae({ title: "合同档案", sort: [], permission: { ...g }, optShow: { ...B }, crudApi: { ...ce }, hasPagination: true }, D), { maxHeight: F } = ne({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 }), O = f([["signingDate", ["parse-time", "{y}-{m}-{d}"]], ["archivistDate", ["parse-time", "{y}-{m}-{d}"]]]), $ = f([]), k = f(false), w = f(false), N = f({});
  function M(l, m) {
    return l.isArchive === I.TRUE.V && (R(l.attachmentDTOList) || R(l.projectFilesDTOS));
  }
  function P(l) {
    x.value = true, A.value = l;
  }
  function U({ row: l, column: m, rowIndex: t, columnIndex: T }) {
    var b;
    if (T === 0 && !((b = l.projectFilesDTOS) != null && b.length)) return "hidden-expand";
  }
  function Q(l) {
    window.open(l);
  }
  function H(l) {
    N.value = l, k.value = false, w.value = true;
  }
  function K(l) {
    l.attachmentFiles = l.attachmentDTOList, N.value = l, k.value = true, w.value = true;
  }
  return (l, m) => {
    const t = X, T = Z, b = se, S = j("common-button"), C = j("common-table"), q = Y("permission"), z = ee;
    return i(), y("div", me, [r("div", fe, [n(a(pe))]), E((i(), c(C, { ref_key: "tableRef", ref: D, data: a(v).data, "empty-text": a(v).emptyText, "max-height": a(F), style: { width: "100%" }, "row-key": "id", "expand-row-keys": $.value, "cell-class-name": U, "return-source-data": "", showEmptySymbol: false, onSelectionChange: a(v).selectionChangeHandler }, { default: o(() => [n(t, { type: "expand", width: "30" }, { default: o((e) => [r("div", ve, [n(C, { "data-format": O.value, stripe: false, data: e.row.projectFilesDTOS, style: { width: "100%" } }, { default: o(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }, { default: o(({ $index: s }) => [r("span", null, u(e.$index + 1) + "." + u(s + 1), 1)]), _: 2 }, 1024), n(t, { prop: "contractDefinitionType", "show-overflow-tooltip": true, label: "合同类型", align: "center", width: "100" }, { default: o(({ row: { sourceRow: s } }) => [s.contractDefinitionType ? (i(), c(T, { key: 0, effect: "plain", type: a(L).V[s.contractDefinitionType].T }, { default: o(() => [V(u(a(L).VL[s.contractDefinitionType]), 1)]), _: 2 }, 1032, ["type"])) : p("", true)]), _: 1 }), n(t, { prop: "signingDate", label: "日期", align: "center", width: "100px" }), n(t, { prop: "serialNumber", "show-overflow-tooltip": false, "min-width": "130", align: "center", label: "合同编号" }), n(t, { prop: "name", "show-overflow-tooltip": false, "min-width": "130", align: "center", label: "名称" }), n(t, { prop: "contractSignBodyName", "show-overflow-tooltip": false, "min-width": "130", align: "center", label: "签订主体" }), n(t, { prop: "contractCreatorName", "show-overflow-tooltip": false, width: "120", align: "center", label: "合同创建人" }), n(t, { "show-overflow-tooltip": true, label: "附件", "min-width": "160px", "header-align": "center" }, { default: o(({ row: { sourceRow: s } }) => {
      var _;
      return [(_ = s == null ? void 0 : s.attachmentDTOList) != null && _.length ? (i(true), y(J, { key: 0 }, W(s.attachmentDTOList, (h) => (i(), y("div", { key: h.id, class: "ellipsis-text" }, [r("span", { class: "tc-primary pointer", onClick: (xe) => Q(h.filePath) }, u(h.name), 9, _e)]))), 128)) : (i(), y("div", { key: 1, style: { width: "100%", "text-align": "center" }, class: "pointer", onClick: (h) => H(s) }, [n(b, { style: { color: "#409eff", position: "absolute", left: "10px", top: "50%", transform: "translateY(-50%)" }, "icon-class": "import" }), m[2] || (m[2] = r("span", { class: "tc-danger" }, "未归档", -1))], 8, he))];
    }), _: 1 }), n(t, { label: "操作", width: "80", align: "center" }, { default: o(({ row: { sourceRow: s } }) => {
      var _;
      return [n(S, { type: "primary", disabled: !((_ = s.attachmentDTOList) != null && _.length), icon: "el-icon-edit", size: "small", onClick: (h) => K(s) }, null, 8, ["disabled", "onClick"])];
    }), _: 1 }), n(t, { prop: "contractArchivistName", "show-overflow-tooltip": false, width: "120", align: "center", label: "合同归档人" }), n(t, { prop: "archivistDate", label: "归档日期", align: "center", width: "100px" })]), _: 2 }, 1032, ["data-format", "data"])])]), _: 1 }), n(t, { key: "selection", type: "selection", width: "55", selectable: M }), n(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(d).visible("serialNumber") ? (i(), c(t, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "合同编号" }, { default: o((e) => [r("span", null, u(e.row.serialNumber), 1)]), _: 1 })) : p("", true), a(d).visible("name") ? (i(), c(t, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目名称" }, { default: o((e) => [r("span", null, u(e.row.name || "-"), 1)]), _: 1 })) : p("", true), a(d).visible("contractSignBodyName") ? (i(), c(t, { key: "contractSignBodyName", prop: "contractSignBodyName", label: "签订主体", align: "left", "min-width": "120" }, { default: o((e) => [r("div", null, u(e.row.contractSignBodyName || "-"), 1)]), _: 1 })) : p("", true), a(d).visible("projectAttribute") ? (i(), c(t, { key: "projectAttribute", prop: "projectAttribute", label: "经营方式", align: "center", width: "90" }, { default: o((e) => [r("div", null, u(e.row.projectAttribute ? a(oe).VL[e.row.projectAttribute] : "-"), 1)]), _: 1 })) : p("", true), a(d).visible("businessType") ? (i(), c(t, { key: "businessType", prop: "businessType", label: "订单类型", align: "center" }, { default: o((e) => [r("div", null, u(e.row.businessType ? a(ie).VL[e.row.businessType] : "-"), 1)]), _: 1 })) : p("", true), a(d).visible("structureStatusName") ? (i(), c(t, { key: "structureStatusName", prop: "structureStatusName", "show-overflow-tooltip": true, "min-width": "120", align: "center", label: "结构类型" }, { default: o((e) => [r("span", null, u(e.row.structureStatusName), 1)]), _: 1 })) : p("", true), a(d).visible("structureArea") ? (i(), c(t, { key: "structureArea", prop: "structureArea", "show-overflow-tooltip": true, width: "120", align: "center", label: "结构工程量(m²/t)" }, { default: o((e) => [r("span", null, u(e.row.structureArea ? e.row.structureArea : "-"), 1)]), _: 1 })) : p("", true), a(d).visible("projectManagerName") ? (i(), c(t, { key: "projectManagerName", prop: "projectManagerName", label: "项目(销售)经理", align: "center", width: "110px" }, { default: o((e) => [r("div", null, u(e.row.projectManagerName ? e.row.projectManagerName : e.row.salesLeaderName || "-"), 1)]), _: 1 })) : p("", true), a(d).visible("contractQuantity") ? (i(), c(t, { key: "contractQuantity", prop: "contractQuantity", label: "合同份数", align: "center", width: "90px" }, { default: o((e) => [r("div", null, u(e.row.contractQuantity), 1)]), _: 1 })) : p("", true), a(d).visible("alreadyArchive") ? (i(), c(t, { key: "alreadyArchive", prop: "alreadyArchive", label: "已归档", align: "center", width: "90px" }, { default: o((e) => [r("div", we, u(e.row.alreadyArchive), 1)]), _: 1 })) : p("", true), a(d).visible("notArchive") ? (i(), c(t, { key: "notArchive", prop: "notArchive", label: "未归档", align: "center", width: "90px" }, { default: o((e) => [r("div", be, u(e.row.notArchive), 1)]), _: 1 })) : p("", true), a(le)([...a(g).detail]) ? (i(), c(t, { key: 11, label: "操作", width: "100px", align: "center" }, { default: o((e) => [E((i(), c(S, { type: "primary", onClick: (s) => P(e.row) }, { default: o(() => m[3] || (m[3] = [V("查看")])), _: 2, __: [3] }, 1032, ["onClick"])), [[q, a(g).detail]])]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "expand-row-keys", "onSelectionChange"])), [[z, a(v).loading]]), n(a(de), { modelValue: x.value, "onUpdate:modelValue": m[0] || (m[0] = (e) => x.value = e), currentInfo: A.value }, null, 8, ["modelValue", "currentInfo"]), n(a(re)), n(ue, { visible: w.value, "onUpdate:visible": m[1] || (m[1] = (e) => w.value = e), isEdit: k.value, projectInfo: N.value, onSuccess: a(v).toQuery }, null, 8, ["visible", "isEdit", "projectInfo", "onSuccess"])]);
  };
} }, je = te(ye, [["__scopeId", "data-v-02cc8748"]]);
export {
  je as default
};
