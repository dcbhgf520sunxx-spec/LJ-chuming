import { ref as p } from "vue";
import { watch as q } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as g } from "vue";
import { createTextVNode as c } from "vue";
import { withModifiers as V } from "vue";
import { ElMessageBox as O } from "element-plus";
import { ElMessage as P } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as F } from "element-plus";
import { ElSwitch as H } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as Q, g as K, u as W, d as X } from "../../../../modules/roster-manage-12e649bc.js";
import { y as m } from "../../../../modules/project-19a12d6b.js";
import Y from "./module/header.vue.js";
import { m as Z, x as ee, o as te, p as oe, n_ as ae, o0 as u, G as h, P as le } from "../../../../shared/runtime.js";
import ne from "./module/personal-info-form.vue.js";
import re from "./module/personal-info.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import "../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../modules/role-8519830b.js";
import "../../../../modules/dept-398bb184.js";
import "../../../../modules/job-fc547e81.js";
import "./module/qr-code-dlg.vue.js";
import "../../../../modules/index-c549a8fd.js";
import "../../../../modules/html2canvas.esm-e0a7d97b.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
const ie = { class: "app-container" }, se = { class: "head-container" }, ce = { key: 0 }, Oe = { __name: "index", setup(ue) {
  const { globalProject: pe, globalProjectId: C } = Z(["globalProject", "globalProjectId"]), v = p(), B = p(), D = p(false), y = p(false), _ = p(), b = p([]), { crud: s, CRUD: de } = ee({ title: "实名制管理", permission: { get: m.get }, crudApi: { ...Q }, requiredQuery: ["projectId"], hasPagination: true }, B), { maxHeight: T } = te({ paginate: true });
  async function j(r) {
    try {
      const n = await K();
      n.length > 0 && (b.value = n.map((o, k) => ({ name: o, id: k })));
    } catch (n) {
      console.log(n);
    }
  }
  j();
  async function I(r, n) {
    try {
      await O.confirm(`确定将 ${r.name} 状态改为${u.VL[n]}?`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const o = { id: r.id, status: n };
      await W(o), P.success("状态修改成功！"), s.refresh();
    } catch (o) {
      console.log(o), r.status = r.status === u.ON_JOB.V ? u.NOT_ON_JOB.V : u.ON_JOB.V;
    }
  }
  function E(r) {
    y.value = true, _.value = r;
  }
  async function S(r) {
    try {
      await O.confirm(`确认将 ${r.name} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ id: r.id }), P.success("删除成功！"), s.refresh(), await v.value.getAgeStatisticsData();
    } catch (n) {
      console.log(n);
    }
  }
  q(() => C.value, (r) => {
    r && (s.query.projectId = C.value, s.toQuery());
  }, { immediate: true, deep: true });
  async function A() {
    s.refresh(), await v.value.getAgeStatisticsData();
  }
  return (r, n) => {
    const o = z, k = F, $ = H, x = R("common-button"), M = R("common-table"), U = G;
    return d(), L("div", ie, [N("div", se, [a(Y, { ref_key: "headerRef", ref: v, nationList: b.value, permission: t(m) }, null, 8, ["nationList", "permission"])]), J((d(), f(M, { ref_key: "tableRef", ref: B, data: t(s).data, "empty-text": t(s).emptyText, "max-height": t(T), style: { width: "100%" } }, { default: l(() => [a(o, { label: "序号", align: "center", width: "50", type: "index" }), a(o, { key: "entryDate", prop: "entryDate", "show-overflow-tooltip": "", align: "center", label: "入职时间" }, { default: l((e) => [e.row.entryDate ? (d(), L("span", ce, i(t(oe)(e.row.entryDate, "{y}-{m}-{d}")), 1)) : g("", true)]), _: 1 }), a(o, { key: "rosterNumber", prop: "rosterNumber", "show-overflow-tooltip": "", align: "center", label: "编号" }, { default: l((e) => [c(i(e.row.rosterNumber), 1)]), _: 1 }), a(o, { key: "wokeName", prop: "wokeName", "show-overflow-tooltip": "", align: "center", label: "工种" }, { default: l((e) => [c(i(e.row.wokeName), 1)]), _: 1 }), a(o, { key: "name", prop: "name", "show-overflow-tooltip": "", align: "center", label: "姓名" }, { default: l((e) => [c(i(e.row.name), 1)]), _: 1 }), a(o, { key: "age", prop: "age", "show-overflow-tooltip": "", align: "center", label: "年龄" }, { default: l((e) => [c(i(e.row.age), 1)]), _: 1 }), a(o, { key: "sex", prop: "sex", "show-overflow-tooltip": "", align: "center", label: "性别" }, { default: l((e) => [N("span", null, i(t(ae).VL[e.row.sex] || "-"), 1)]), _: 1 }), a(o, { key: "nation", prop: "nation", "show-overflow-tooltip": "", align: "center", label: "民族" }, { default: l((e) => [c(i(e.row.nation), 1)]), _: 1 }), a(o, { key: "idNumber", prop: "idNumber", "show-overflow-tooltip": "", align: "center", label: "身份证号", width: "160px" }, { default: l((e) => [N("span", null, i(e.row.idNumber || "-"), 1)]), _: 1 }), a(o, { key: "homeAddress", prop: "homeAddress", "show-overflow-tooltip": "", align: "center", label: "家庭住址", width: "120px" }, { default: l((e) => [c(i(e.row.homeAddress), 1)]), _: 1 }), a(o, { key: "phone", prop: "phone", "show-overflow-tooltip": "", align: "center", label: "联系方式", width: "120px" }, { default: l((e) => [c(i(e.row.phone), 1)]), _: 1 }), a(o, { key: "cumulativePenalty", prop: "cumulativePenalty", "show-overflow-tooltip": "", align: "center", label: "累计处罚（元）", width: "120px" }, { default: l((e) => [c(i(e.row.cumulativePenalty), 1)]), _: 1 }), a(o, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", align: "center", label: "所属单位", width: "140px" }, { default: l((e) => [c(i(e.row.supplierName || "-"), 1)]), _: 1 }), a(o, { key: "status", prop: "status", "show-overflow-tooltip": "", align: "center", label: "状态", width: "120px" }, { default: l((e) => [a(k, { size: "large", type: t(u).V[e.row.status].T, style: { "margin-right": "10px" } }, { default: l(() => [c(i(t(u).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"]), a($, { modelValue: e.row.status, "onUpdate:modelValue": (w) => e.row.status = w, "active-color": "#67c23a", "inactive-color": "#F56C6C", "active-value": t(u).ON_JOB.V, "inactive-value": t(u).NOT_ON_JOB.V, disabled: !t(h)(t(m).editStatus), onChange: (w) => I(e.row, e.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 }), a(o, { align: "center", label: "操作", width: "200px" }, { default: l((e) => [t(h)(t(m).detail) ? (d(), f(x, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: V((w) => E(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true), t(h)(t(m).edit) ? (d(), f(x, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", onClick: V((w) => t(s).toEdit(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true), t(h)(t(m).del) ? (d(), f(x, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", onClick: V((w) => S(e.row), ["stop"]) }, null, 8, ["onClick"])) : g("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[U, t(s).loading]]), a(t(le)), a(ne, { visible: D.value, "onUpdate:visible": n[0] || (n[0] = (e) => D.value = e), currentRow: _.value, nationList: b.value, projectId: t(s).query.projectId, onSuccess: A }, null, 8, ["visible", "currentRow", "nationList", "projectId"]), a(re, { visible: y.value, "onUpdate:visible": n[1] || (n[1] = (e) => y.value = e), currentRow: _.value }, null, 8, ["visible", "currentRow"])]);
  };
} };
export {
  Oe as default
};
