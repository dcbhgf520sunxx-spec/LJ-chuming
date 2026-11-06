import { ref as d } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as M } from "vue";
import { unref as a } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as g } from "vue";
import { createTextVNode as s } from "vue";
import { withModifiers as N } from "vue";
import { ElMessageBox as O } from "element-plus";
import { ElMessage as T } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElSwitch as F } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as I, a as q, u as j, d as G } from "../../../modules/roster-34ff8428.js";
import { a as w } from "../../../modules/user-2de6904c.js";
import K from "./module/header.vue.js";
import { x as Q, o as W, p as X, n_ as Y, o0 as c, G as h, P as Z } from "../../../shared/runtime.js";
import ee from "./module/personal-info-form.vue.js";
import te from "./module/personal-info.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/role-8519830b.js";
import "../../../modules/dept-398bb184.js";
import "../../../modules/job-fc547e81.js";
import "./module/qr-code-dlg.vue.js";
import "../../../modules/index-c549a8fd.js";
import "../../../modules/html2canvas.esm-e0a7d97b.js";
import "../../../modules/tree-select-86c0f12c.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const oe = { class: "app-container" }, ae = { class: "head-container" }, ne = { key: 0 }, Ne = { __name: "index", setup(le) {
  const V = d(), B = d(false), v = d(false), _ = d(), y = d([]), { crud: p } = Q({ title: "花名册", permission: { get: w.get }, crudApi: { ...I }, hasPagination: true }, V), { maxHeight: L } = W({ paginate: true });
  async function S(r) {
    try {
      const l = await q();
      l.length > 0 && (y.value = l.map((t, b) => ({ name: t, id: b })));
    } catch (l) {
      console.log(l);
    }
  }
  S();
  async function E(r, l) {
    try {
      await O.confirm(`确定将 ${r.name} 状态改为${c.VL[l]}?`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const t = { id: r.id, status: l };
      await j(t), T.success("状态修改成功！"), p.refresh();
    } catch (t) {
      console.log(t), r.status = r.status === c.ON_JOB.V ? c.NOT_ON_JOB.V : c.ON_JOB.V;
    }
  }
  function R(r) {
    v.value = true, _.value = r;
  }
  async function P(r) {
    try {
      await O.confirm(`确认将 ${r.name} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await G({ id: r.id }), T.success("删除成功！"), p.refresh();
    } catch (l) {
      console.log(l);
    }
  }
  return (r, l) => {
    const t = U, b = z, $ = F, k = C("common-button"), A = C("common-table"), J = H;
    return u(), D("div", oe, [x("div", ae, [o(K, { ref: "header", nationList: y.value }, null, 8, ["nationList"])]), M((u(), f(A, { ref_key: "tableRef", ref: V, data: a(p).data, "empty-text": a(p).emptyText, "max-height": a(L), style: { width: "100%" } }, { default: n(() => [o(t, { label: "序号", align: "center", width: "50", type: "index" }), o(t, { key: "entryDate", prop: "entryDate", "show-overflow-tooltip": "", align: "center", label: "入职时间" }, { default: n((e) => [e.row.entryDate ? (u(), D("span", ne, i(a(X)(e.row.entryDate, "{y}-{m}-{d}")), 1)) : g("", true)]), _: 1 }), o(t, { key: "username :", prop: "username", "show-overflow-tooltip": "", align: "center", label: "编号" }, { default: n((e) => [s(i(e.row.username), 1)]), _: 1 }), o(t, { key: "name", prop: "name", "show-overflow-tooltip": "", align: "center", label: "姓名" }, { default: n((e) => [s(i(e.row.name), 1)]), _: 1 }), o(t, { key: "age", prop: "age", "show-overflow-tooltip": "", align: "center", label: "年龄" }, { default: n((e) => [s(i(e.row.age), 1)]), _: 1 }), o(t, { key: "sex", prop: "sex", "show-overflow-tooltip": "", align: "center", label: "性别" }, { default: n((e) => [x("span", null, i(a(Y).VL[e.row.sex] || "-"), 1)]), _: 1 }), o(t, { key: "nation", prop: "nation", "show-overflow-tooltip": "", align: "center", label: "民族" }, { default: n((e) => [s(i(e.row.nation), 1)]), _: 1 }), o(t, { key: "idNumber", prop: "idNumber", "show-overflow-tooltip": "", align: "center", label: "身份证号", width: "160px" }, { default: n((e) => [x("span", null, i(e.row.idNumber || "-"), 1)]), _: 1 }), o(t, { key: "homeAddress", prop: "homeAddress", "show-overflow-tooltip": "", align: "center", label: "家庭住址", width: "120px" }, { default: n((e) => [s(i(e.row.homeAddress), 1)]), _: 1 }), o(t, { key: "phone", prop: "phone", "show-overflow-tooltip": "", align: "center", label: "联系方式", width: "120px" }, { default: n((e) => [s(i(e.row.phone), 1)]), _: 1 }), o(t, { key: "remainingBehaviorScore", prop: "remainingBehaviorScore", "show-overflow-tooltip": "", align: "center", label: "剩余行为分" }, { default: n((e) => [s(i(e.row.remainingBehaviorScore), 1)]), _: 1 }), o(t, { key: "cumulativePenalty", prop: "cumulativePenalty", "show-overflow-tooltip": "", align: "center", label: "累计处罚（元）", width: "120px" }, { default: n((e) => [s(i(e.row.cumulativePenalty), 1)]), _: 1 }), o(t, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", align: "center", label: "所属单位", width: "140px" }, { default: n((e) => [s(i(e.row.supplierName || "-"), 1)]), _: 1 }), o(t, { key: "status", prop: "status", "show-overflow-tooltip": "", align: "center", label: "状态", width: "120px" }, { default: n((e) => [o(b, { size: "large", type: a(c).V[e.row.status].T, style: { "margin-right": "10px" } }, { default: n(() => [s(i(a(c).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"]), o($, { modelValue: e.row.status, "onUpdate:modelValue": (m) => e.row.status = m, "active-color": "#67c23a", "inactive-color": "#F56C6C", "active-value": a(c).ON_JOB.V, "inactive-value": a(c).NOT_ON_JOB.V, disabled: !a(h)(a(w).editStatus), onChange: (m) => E(e.row, e.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 }), o(t, { align: "center", label: "操作", width: "200px" }, { default: n((e) => [a(h)(a(w).detail) ? (u(), f(k, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: N((m) => R(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true), a(h)(a(w).edit) ? (u(), f(k, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", onClick: N((m) => a(p).toEdit(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true), a(h)(a(w).del) ? (u(), f(k, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", onClick: N((m) => P(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[J, a(p).loading]]), o(a(Z)), o(ee, { visible: B.value, "onUpdate:visible": l[0] || (l[0] = (e) => B.value = e), currentRow: _.value, nationList: y.value, onSuccess: a(p).refresh }, null, 8, ["visible", "currentRow", "nationList", "onSuccess"]), o(te, { visible: v.value, "onUpdate:visible": l[1] || (l[1] = (e) => v.value = e), currentRow: _.value }, null, 8, ["visible", "currentRow"])]);
  };
} };
export {
  Ne as default
};
