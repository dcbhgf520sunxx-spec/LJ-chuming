import { useStore as ue } from "vuex";
import { ref as m } from "vue";
import { provide as F } from "vue";
import { computed as ce } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as de } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as f } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as C } from "vue";
import { ElSelect as me } from "element-plus";
import { Fragment as z } from "vue";
import { renderList as pe } from "vue";
import { ElMessageBox as fe } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { ElTag as he } from "element-plus";
import { ElOption as ve } from "element-plus";
import { vLoading as _e } from "element-plus";
import { _ as ye, t as ge, x as Ne, kh as ke, o as Ce, c1 as b, p as Q, gD as Te, bN as xe, bV as Se, G as g, an as je, L as Ve, ki as Ae, P as Ee, kj as De } from "../../../shared/runtime.js";
import Le from "../info/index.vue.js";
import Pe from "./members/index.vue.js";
import { L as p } from "../../../modules/contract-9b18cc88.js";
import Ie from "./module/header.vue.js";
import Oe from "./module/form.vue.js";
import Ue from "./module/contract-type-select-form.vue.js";
import "../info/zn-base.vue.js";
import "../info/customer.vue.js";
import "../../../modules/region-cascader-39b54da2.js";
import "../info/members.vue.js";
import "../info/money-form.vue.js";
import "../info/components/user-dept-cascader.vue.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
import "../info/settle-form.vue.js";
import "../info/variation-order.vue.js";
import "../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/complete-list/index.vue.js";
import "./module/base-form.vue.js";
import "../../../modules/dept-398bb184.js";
import "../../../modules/tree-select-86c0f12c.js";
import "./module/customer-form.vue.js";
import "./module/project-members.vue.js";
import "./module/quoto-bid-contract-dialog.vue.js";
import "../../../modules/win-bid-list-285b5b2e.js";
const Me = { class: "app-container" }, Be = { class: "head-container" }, He = { __name: "index", setup(Re) {
  const N = ue(), { decimalPrecision: q } = ge(), L = m([]), P = m([]);
  F("machiningData", L), F("installData", P), ce(() => N.getters.projectNameShowConfig.showProjectFullName);
  const G = { add: true, edit: false, del: false, download: false }, I = m(), O = m(), _ = m(false), U = m(), M = m(), B = m(), T = m(false), Y = m(), x = m(false), k = m(false), H = m({}), R = m([]), { crud: h, columns: u, CRUD: y } = Ne({ title: "合同档案", invisibleColumns: [], permission: { ...p }, optShow: { ...G }, crudApi: { ...ke }, hasPagination: true }, I), { maxHeight: J } = Ce({ wrapperBox: ".contractProject", paginate: true, extraHeight: 40 });
  function W(n) {
    O.value = n, _.value = true;
  }
  function X() {
    _.value = false, h.toQuery();
  }
  function Z(n, s) {
    L.value = n, P.value = s;
  }
  async function ee(n, s) {
    try {
      await fe.confirm(`此操作将把 “${n.name}” 状态更改为 “${b.VL[s]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await De(n.id, s, false), h.notify(`“${n.name}” 变更为 “${b.VL[s]}” 成功`, y.NOTIFICATION_TYPE.SUCCESS), h.refresh(), S();
    } catch (a) {
      console.log(a), n.status = n.originStatus;
    }
  }
  function te(n) {
    U.value = n.id, M.value = n.status, B.value = n.name, T.value = true;
  }
  y.HOOK.handleRefresh = (n, s) => {
    s.data.content.forEach((a, j) => {
      a.statusColor = a.status === b.COMPLETE.V ? "success" : a.status === b.SUSPEND.V ? "warning" : null, a.originStatus = a.status, a.idx = j + 1, a.isChild = false, a.children = a.subcontractList.map((v, V) => (v.idx = a.idx + "." + (V + 1), v.isChild = true, v));
    });
  };
  function ae({ row: n, rowIndex: s }) {
    var a;
    return !n.isChild && ((a = n.subcontractList) != null && a.length) ? "parent-row" : n.isChild ? "child-row" : "";
  }
  function S() {
    N.dispatch("project/fetchUserProjects"), N.dispatch("project/fetchProjectTree"), N.dispatch("project/fetchProjectAllType");
  }
  y.HOOK.afterDelete = () => {
    S();
  }, y.HOOK.beforeToAdd = (n, s) => {
    if (!k.value) return x.value = true, false;
  }, y.HOOK.afterToAdd = y.HOOK.afterAddCancel = () => {
    k.value = false;
  };
  function oe(n) {
    R.value = n;
  }
  function re(n) {
    return R.value;
  }
  function le(n) {
    H.value = n, k.value = true, h.toAdd();
  }
  return (n, s) => {
    const a = we, j = be, v = he, V = ve, $ = A("common-button"), ne = A("common-table"), ie = A("common-dialog"), K = de("permission"), se = _e;
    return o(), E("div", Me, [c("div", Be, [f(t(Ie), { onProjectChange: S, onContentChange: Z, onTotalAmountChang: oe })]), D((o(), r(ne, { ref_key: "tableRef", ref: I, "cell-class-name": ae, data: t(h).data, "empty-text": t(h).emptyText, "max-height": t(J), showEmptySymbol: false, stripe: false, "return-source-data": "", "show-summary": "", "summary-method": re, "row-key": "id", style: { width: "100%" } }, { default: l(() => [f(a, { align: "center", fixed: "left", label: "序号", prop: "idx", width: "60" }), t(u).visible("createTime") ? (o(), r(a, { key: "createTime", align: "center", fixed: "left", label: "立项日期", prop: "createTime", width: "100px" }, { default: l((e) => [c("div", null, d(e.row.createTime ? t(Q)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : i("", true), t(u).visible("serialNumber") ? (o(), r(a, { key: "serialNumber", "show-overflow-tooltip": false, align: "center", fixed: "left", label: "合同编号", "min-width": "130", prop: "serialNumber" })) : i("", true), t(u).visible("shortName") ? (o(), r(a, { key: "shortName", "show-overflow-tooltip": true, label: "项目简称", "min-width": "150", prop: "shortName" }, { default: l((e) => [f(j, { content: e.row.serialNumber + " " + e.row.name, "show-after": 50, placement: "top" }, { default: l(() => [c("span", null, d(e.row.shortName), 1)]), _: 2 }, 1032, ["content"])]), _: 1 })) : i("", true), t(u).visible("contractSignBodyName") ? (o(), r(a, { key: "contractSignBodyName", align: "left", label: "签订主体", "min-width": "120", prop: "contractSignBodyName" }, { default: l((e) => [c("div", null, d(e.row.contractSignBodyName || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("projectAttribute") ? (o(), r(a, { key: "projectAttribute", align: "center", label: "经营方式", prop: "projectAttribute", width: "90" }, { default: l((e) => [c("div", null, d(e.row.projectAttribute ? t(Te).VL[e.row.projectAttribute] : "-"), 1)]), _: 1 })) : i("", true), t(u).visible("businessType") ? (o(), r(a, { key: "businessType", align: "center", label: "订单类型", prop: "businessType", width: "90" }, { default: l((e) => [c("div", null, d(e.row.businessType ? t(xe).VL[e.row.businessType] : "-"), 1)]), _: 1 })) : i("", true), t(u).visible("structureStatusName") ? (o(), r(a, { key: "structureStatusName", label: "结构类型", "show-overflow-tooltip": true, align: "center", "min-width": "120", prop: "structureStatusName" }, { default: l((e) => [c("span", null, d(e.row.structureStatusName), 1)]), _: 1 })) : i("", true), t(u).visible("structureArea") ? (o(), r(a, { key: "structureArea", label: "结构工程量(m²/t)", "show-overflow-tooltip": true, align: "center", prop: "structureArea", width: "130" }, { default: l((e) => [c("span", null, d(e.row.structureArea ? e.row.structureArea : "-"), 1)]), _: 1 })) : i("", true), t(u).visible("contractAmount") ? (o(), r(a, { key: "contractAmount", label: "合同金额(元)", "show-overflow-tooltip": true, align: "center", "min-width": "120", prop: "contractAmount" }, { default: l((e) => [c("span", null, d(e.row.contractAmount ? t(Se)(e.row.contractAmount, t(q).contract) : "-"), 1)]), _: 1 })) : i("", true), t(u).visible("endDate") ? (o(), r(a, { key: "endDate", align: "center", label: "约定完工日期", prop: "endDate", width: "100px" }, { default: l((e) => [c("div", null, d(e.row.endDate ? t(Q)(e.row.endDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : i("", true), s[5] || (s[5] = C(" --> ")), t(u).visible("structureTypeName") ? (o(), r(a, { key: "structureTypeName", label: "结构类型", "show-overflow-tooltip": true, align: "center", "min-width": "120", prop: "structureTypeName" }, { default: l((e) => [c("span", null, d(e.row.structureTypeName || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("allDays") ? (o(), r(a, { key: "allDays", align: "center", label: "总工期(天)", prop: "allDays", width: "80" }, { default: l((e) => [c("div", null, d(e.row.allDays), 1)]), _: 1 })) : i("", true), t(u).visible("projectManagerName") ? (o(), r(a, { key: "projectManagerName", align: "center", label: "项目(销售)经理", prop: "projectManagerName", width: "110px" }, { default: l((e) => [c("div", null, d(e.row.projectManagerName ? e.row.projectManagerName : e.row.salesLeaderName || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("infoSourceName") ? (o(), r(a, { key: "infoSourceName", label: "信息来源", "show-overflow-tooltip": true, align: "center", prop: "infoSourceName", width: "160" }, { default: l((e) => [c("span", null, d(e.row.infoSourceName), 1)]), _: 1 })) : i("", true), t(u).visible("userName") ? (o(), r(a, { key: "userName", align: "center", label: "创建人", prop: "userName", width: "100px" }, { default: l((e) => [c("div", null, d(e.row.userName || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("customerUnit") ? (o(), r(a, { key: "customerUnit", align: "center", "show-overflow-tooltip": true, label: "客户名称", "min-width": "150", prop: "customerUnit" }, { default: l((e) => [c("span", null, d(e.row.customerUnit || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("address") ? (o(), r(a, { key: "address", align: "center", "show-overflow-tooltip": true, label: "项目地点", "min-width": "150", prop: "address" }, { default: l((e) => [c("span", null, d(e.row.address || "-"), 1)]), _: 1 })) : i("", true), t(u).visible("isEffective") ? (o(), r(a, { key: "isEffective", align: "center", label: "状态", prop: "isEffective", width: "100px" }, { default: l(({ row: e }) => [e.isEffective ? (o(), r(v, { key: 0, effect: "plain", type: "success" }, { default: l(() => s[3] || (s[3] = [C("有效合同")])), _: 1, __: [3] })) : (o(), r(v, { key: 1, effect: "plain", type: "danger" }, { default: l(() => s[4] || (s[4] = [C("无效合同")])), _: 1, __: [4] }))]), _: 1 })) : i("", true), t(u).visible("status") ? (o(), r(a, { key: "status", align: "center", fixed: "right", label: "状态", prop: "status", width: "120" }, { default: l((e) => [t(g)(t(p).editStatus) && e.row.status !== t(b).SETTLED.V ? (o(), r(t(me), { key: 0, modelValue: e.row.status, "onUpdate:modelValue": (w) => e.row.status = w, size: "default", onChange: (w) => ee(e.row, e.row.status) }, { default: l(() => [(o(true), E(z, null, pe(t(b).ENUM, (w) => (o(), E(z, null, [w.V != t(b).SETTLED.V ? (o(), r(V, { key: w.V, label: w.L, value: w.V }, null, 8, ["label", "value"])) : i("", true)], 64))), 256))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (o(), r(v, { key: 1, type: e.row.statusColor }, { default: l(() => [C(d(t(b).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : i("", true), t(g)(t(p).editMember) ? (o(), r(a, { key: 19, align: "center", fixed: "right", label: "成员管理", width: "80" }, { default: l((e) => [t(g)(t(p).editMember) ? (o(), r($, { key: 0, disabled: e.row.status !== t(b).ENUM.PROCESS.V, icon: "el-icon-user", type: "info", size: "default", onClick: (w) => W(e.row.id) }, null, 8, ["disabled", "onClick"])) : i("", true)]), _: 1 })) : i("", true), t(g)([...t(p).detail, ...t(p).del, , ...t(p).download]) ? (o(), r(a, { key: 20, align: "center", fixed: "right", label: "操作", width: "240px" }, { default: l((e) => [t(g)(t(p).detail) ? (o(), r($, { key: 0, icon: "el-icon-view", type: "info", onClick: (w) => te(e.row) }, null, 8, ["onClick"])) : i("", true), D(f(t(je), { data: e.row }, null, 8, ["data"]), [[K, t(p).edit]]), D(f(Ve, { fn: t(Ae), params: { projectId: e.row.id } }, null, 8, ["fn", "params"]), [[K, t(p).download]])]), _: 1 })) : i("", true)]), _: 1, __: [5] }, 8, ["data", "empty-text", "max-height"])), [[se, t(h).loading]]), f(t(Oe), { boolCanAdd: k.value, contractTypeInfo: H.value, permission: t(p) }, null, 8, ["boolCanAdd", "contractTypeInfo", "permission"]), f(t(Ue), { visible: x.value, "onUpdate:visible": s[0] || (s[0] = (e) => x.value = e), onNext: le }, null, 8, ["visible"]), f(t(Le), { modelValue: T.value, "onUpdate:modelValue": s[1] || (s[1] = (e) => T.value = e), "project-id": U.value, "project-name": B.value, "project-status": M.value }, null, 8, ["modelValue", "project-id", "project-name", "project-status"]), f(ie, { modelValue: _.value, "onUpdate:modelValue": s[2] || (s[2] = (e) => _.value = e), "before-close": () => {
      _.value = false;
    }, "close-on-click-modal": false, "show-close": true, title: "项目成员", top: "8vh", width: "500px" }, { default: l(() => [f(t(Pe), { ref_key: "membersList", ref: Y, permission: t(p), "project-id": O.value, refresh: _.value, onSuccess: X }, null, 8, ["permission", "project-id", "refresh"])]), _: 1 }, 8, ["modelValue", "before-close"]), f(t(Ee))]);
  };
} }, vt = ye(He, [["__scopeId", "data-v-7ad5a5c6"]]);
export {
  vt as default
};
