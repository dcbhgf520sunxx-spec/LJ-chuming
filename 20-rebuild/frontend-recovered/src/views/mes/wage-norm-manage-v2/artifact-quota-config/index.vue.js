import { ref as L } from "vue";
import { provide as E } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as _ } from "vue";
import { unref as t } from "vue";
import { withDirectives as et } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as ot } from "vue";
import { renderList as at } from "vue";
import { withModifiers as T } from "vue";
import { ElMessage as j } from "element-plus";
import { ElMessageBox as it } from "element-plus";
import { ElTableColumn as nt } from "element-plus";
import { ElTag as st } from "element-plus";
import { ElTooltip as rt } from "element-plus";
import { vLoading as lt } from "element-plus";
import { a as ct } from "../../../../modules/common-f216149e.js";
import { c as dt, d as ut, g as pt } from "../../../../modules/artifact-quota-config-f98bdf94.js";
import { P as mt } from "../../../../modules/base-6bc46ddf.js";
import { _ as ft, x as _t, s2 as k, o as ht, q9 as yt, i as w, es as gt, s3 as F, e0 as bt, e1 as wt, bV as H, G as O, P as Lt } from "../../../../shared/runtime.js";
import kt from "./module/form.vue.js";
import Ct from "./module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/use-section-all-504a2069.js";
const vt = { class: "app-container" }, xt = { class: "head-container" }, Et = { style: { padding: "0 10px", cursor: "pointer" } }, Tt = { key: 1 }, Ot = { style: { padding: "0 10px", cursor: "pointer" } }, Pt = { key: 1 }, Nt = { key: 0 }, Bt = { key: 1 }, It = { key: 0 }, Vt = { key: 1 }, zt = { key: 0 }, St = { key: 1 }, qt = { key: 0, class: "detailList" }, At = { key: 1 }, Dt = { __name: "index", setup(Mt) {
  const Q = { add: true, edit: false, del: false, download: false }, P = L(), { crud: l, columns: m, CRUD: W } = _t({ title: "构件定额", permission: { ...k }, optShow: { ...Q }, crudApi: { ...dt }, hasPagination: true }, P), N = L([]), B = L([]), { maxHeight: Y } = ht({ paginate: true }), C = Object.values(yt.V).map((o) => ({ conditionEnum: o.V, name: o.L })), g = L(false);
  async function G() {
    try {
      const o = await mt();
      g.value = o || false, o || j.error("请先配置工价统计截止日！");
    } catch (o) {
      console.log("工价统计截止日", o);
    }
  }
  W.HOOK.handleRefresh = (o, f) => {
    f.data.content = f.data.content.map((n) => (n.conditionList = C.map((b) => {
      var h;
      return ((h = n.conditionList) == null ? void 0 : h.find((x) => x.conditionEnum === b.conditionEnum)) || { conditionEnum: b.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 };
    }), n)), G();
  };
  async function K(o) {
    try {
      await it.confirm(`确认将 ${o.serialNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ut({ id: o.id }), j.success("删除成功！"), l.refresh();
    } catch (f) {
      console.log(f);
    }
  }
  async function X() {
    try {
      const { content: o } = await ct();
      N.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  async function J() {
    try {
      const { content: o } = await pt({ mesProductEnum: 1 });
      B.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  function Z(o) {
    const copy = JSON.parse(JSON.stringify({
      branchCompanyIdList: o.branchCompanyIdList || [],
      workshopIdList: o.workshopIdList || [],
      productClassificationEnum: o.productClassificationEnum,
      artifactClassIdList: o.artifactClassIdList || [],
      artifactNameList: o.artifactNameList || [],
      processId: o.process?.id,
      measureUnit: o.measureUnit,
      quotaType: o.quotaType,
      organizationInsidePrice: o.organizationInsidePrice,
      organizationOutsidePrice: o.organizationOutsidePrice,
      conditionList: (o.conditionList || []).map(({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }) => ({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }))
    }));
    l.resetForm(copy), l.toAdd();
  }
  return J(), X(), E("branchList", N), E("artifactTypeList", B), E("boolConfig", g), (o, f) => {
    const n = nt, b = st, v = rt, h = $("common-button"), x = $("common-table"), tt = lt;
    return a(), p("div", vt, [d("div", xt, [_(t(Ct))]), et((a(), r(x, { ref_key: "tableRef", ref: P, data: t(l).data, "empty-text": t(l).emptyText, "max-height": t(Y), showEmptySymbol: false, style: { width: "100%" } }, { default: s(() => [_(n, { type: "index", label: "序号", align: "center", width: "55", fixed: "left" }), t(m).visible("branchCompanyList") ? (a(), r(n, { key: "branchCompanyList", prop: "branchCompanyList", "show-overflow-tooltip": true, label: "适用机构", align: "center", fixed: "left" }, { default: s((e) => [t(w)(e.row.branchCompanyList) ? (a(), r(v, { key: 0, content: e.row.branchCompanyList.map((i) => i.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(b, { round: "" }, { default: s(() => {
      var i;
      return [d("span", Et, c((i = e.row.branchCompanyList) == null ? void 0 : i.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), p("span", Tt, "-"))]), _: 1 })) : u("", true), t(m).visible("workshopList") ? (a(), r(n, { key: "workshopList", prop: "workshopList", "show-overflow-tooltip": true, label: "适用车间", align: "center", fixed: "left" }, { default: s((e) => [t(w)(e.row.workshopList) ? (a(), r(v, { key: 0, content: e.row.workshopList.map((i) => i.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(b, { round: "" }, { default: s(() => {
      var i;
      return [d("span", Ot, c((i = e.row.workshopList) == null ? void 0 : i.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), p("span", Pt, "-"))]), _: 1 })) : u("", true), t(m).visible("productClassificationEnum") ? (a(), r(n, { key: "productClassificationEnum", prop: "productClassificationEnum", "show-overflow-tooltip": true, label: "主次构件类型", align: "center", fixed: "left", "min-width": "100" }, { default: s((e) => [t(w)(e.row.productClassificationEnum) ? (a(), p("span", Nt, c(t(gt).VL[e.row.productClassificationEnum]), 1)) : (a(), p("span", Bt, "-"))]), _: 1 })) : u("", true), t(m).visible("artifactClassList") ? (a(), r(n, { key: "artifactClassList", prop: "artifactClassList", "show-overflow-tooltip": true, label: "构件类型", align: "center", fixed: "left", "min-width": "120" }, { default: s((e) => [t(w)(e.row.artifactClassList) ? (a(), p("span", It, c(e.row.artifactClassList.map((i) => i.name).join("、")), 1)) : (a(), p("span", Vt, "-"))]), _: 1 })) : u("", true), t(m).visible("artifactNames") ? (a(), r(n, { key: "artifactNames", prop: "artifactNames", "show-overflow-tooltip": true, label: "构件名称", align: "center", fixed: "left", "min-width": "140" }, { default: s((e) => [e.row.artifactNames ? (a(), p("span", zt, c(e.row.artifactNames), 1)) : (a(), p("span", St, "【 已默认选择全部 】"))]), _: 1 })) : u("", true), t(m).visible("process") ? (a(), r(n, { key: "process", prop: "process", label: "工序", align: "center", fixed: "left" }, { default: s((e) => {
      var i;
      return [d("span", null, c(((i = e.row.process) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 })) : u("", true), t(m).visible("quotaType") ? (a(), r(n, { key: "quotaType", prop: "quotaType", label: "定额类型", align: "center", fixed: "left" }, { default: s((e) => [d("span", null, c(t(F).VL[e.row.quotaType] || "-"), 1)]), _: 1 })) : u("", true), (a(true), p(ot, null, at(t(C), (e, i) => (a(), r(n, { key: i, prop: e.name, label: e.name, align: "center", "min-width": "130" }, { default: s((y) => {
      var I, V, z, S, q, A, D, M, U, R;
      return [y.row.quotaType === t(F).VARIABLE.V && t(w)((V = (I = y.row.conditionList) == null ? void 0 : I[i]) == null ? void 0 : V.numberOne) ? (a(), p("div", qt, [d("span", null, c((S = (z = y.row.conditionList) == null ? void 0 : z[i]) == null ? void 0 : S.numberOne), 1), d("span", null, c(t(bt).VL[(A = (q = y.row.conditionList) == null ? void 0 : q[i]) == null ? void 0 : A.comparisonOperatorOne]), 1), f[0] || (f[0] = d("span", null, "X", -1)), d("span", null, c(t(wt).VL[(M = (D = y.row.conditionList) == null ? void 0 : D[i]) == null ? void 0 : M.comparisonOperatorTwo]), 1), d("span", null, c((R = (U = y.row.conditionList) == null ? void 0 : U[i]) == null ? void 0 : R.numberTwo), 1)])) : (a(), p("span", At, "-"))];
    }), _: 2 }, 1032, ["prop", "label"]))), 128)), t(m).visible("measureUnit") ? (a(), r(n, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", fixed: "right", width: "70" }, { default: s((e) => [d("span", null, c(e.row.measureUnit || "-"), 1)]), _: 1 })) : u("", true), t(m).visible("serialNumber") ? (a(), r(n, { key: "serialNumber", prop: "serialNumber", label: "定额编号", align: "center", fixed: "right" }, { default: s((e) => [d("span", null, c(e.row.serialNumber || "-"), 1)]), _: 1 })) : u("", true), _(n, { label: "定额单价", align: "center", fixed: "right" }, { default: s(() => [t(m).visible("organizationInsidePrice") ? (a(), r(n, { key: "organizationInsidePrice", prop: "organizationInsidePrice", label: "编制内（元）", align: "center", "min-width": "100" }, { default: s((e) => [d("span", null, c(t(H)(e.row.organizationInsidePrice) ?? "-"), 1)]), _: 1 })) : u("", true), t(m).visible("organizationOutsidePrice") ? (a(), r(n, { key: "organizationOutsidePrice", prop: "organizationOutsidePrice", label: "编制外（元）", align: "center", "min-width": "100" }, { default: s((e) => [d("span", null, c(t(H)(e.row.organizationOutsidePrice) ?? "-"), 1)]), _: 1 })) : u("", true)]), _: 1 }), _(n, { label: "操作", prop: "operation", align: "center", fixed: "right", "min-width": "180" }, { default: s((e) => [t(O)(t(k).add) ? (a(), r(h, { key: 0, icon: "el-icon-DocumentCopy", size: "default", type: "success", disabled: !g.value, onClick: T((i) => Z(e.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true), t(O)(t(k).edit) ? (a(), r(h, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", disabled: !g.value, onClick: T((i) => t(l).toEdit(e.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true), t(O)(t(k).del) ? (a(), r(h, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", disabled: !g.value, onClick: T((i) => K(e.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[tt, t(l).loading]]), _(t(kt)), _(t(Lt))]);
  };
} }, Jt = ft(Dt, [["__scopeId", "data-v-eecdc453"]]);
export {
  Jt as default
};
