import { ref as n } from "vue";
import { reactive as X } from "vue";
import { computed as Y } from "vue";
import { watch as V } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as Z } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as f } from "vue";
import { withDirectives as O } from "vue";
import { unref as s } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as P } from "vue";
import { createCommentVNode as p } from "vue";
import { toDisplayString as A } from "vue";
import { ElMessage as T } from "element-plus";
import { ElMessageBox as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElTree as ae } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { vLoading as le } from "element-plus";
import { l as _, _ as re, ds as ne, i as oe, x as ie, o as ue, G as H, bN as de } from "../../../shared/runtime.js";
import { b as C } from "../../../modules/user-2de6904c.js";
import ce from "./module/header.vue.js";
function fe(l) {
  return _({ module: "user", url: "project/listAllProjectBrief", method: "get", params: l });
}
function me(l) {
  return _({ module: "user", url: "user", method: "post", data: l });
}
function pe(l) {
  return _({ module: "user", url: "user", method: "put", data: l });
}
function _e(l) {
  return _({ module: "user", url: "user", method: "delete", data: l });
}
function be(l) {
  return _({ module: "user", url: "project/projectIdsUsers", method: "post", data: l });
}
const ve = { add: me, edit: pe, del: _e, get: fe };
const he = { class: "app-container wrap" }, ge = { class: "wrap-left" }, ye = { style: { "max-height": "674px", "overflow-y": "auto" } }, we = { class: "wrap-right" }, xe = { class: "wrap-right-herder" }, ke = { __name: "index", setup(l) {
  const { userDeptTree: b } = ne(), y = n(), v = n(), I = { children: "children", label: "label" }, R = n([]), N = n([]), w = n([]), J = X({ data: false }), h = n(false), S = n(), D = n(), M = n([]), $ = Y(() => N.value), q = { add: false, edit: false, del: false, download: false };
  V(() => v.value, (t) => {
    y.value.filter(t);
  }), V(b, (t) => {
    oe(b.value) && L();
  }, { immediate: true, deep: true });
  function L() {
    let t = [], e = [];
    t = JSON.parse(JSON.stringify(b.value)), x(t, true), e = JSON.parse(JSON.stringify(b.value)), x(e, false), R.value = t, N.value = e;
  }
  const z = (t, e) => t ? e.label.indexOf(t) !== -1 || e.parentLabel && e.parentLabel.indexOf(t) !== -1 : true;
  function x(t, e, d) {
    t.forEach((a) => {
      a.disabled = e, a.parentLabel = d, a.isUser || (a.id === 1 ? a.label = "<公司>" + a.label : a.label = "<部门>" + a.label, a.id = -a.id), a.children && x(a.children, e, a.label);
    });
  }
  const F = () => {
    M.value = [];
  }, G = () => {
    let t = y.value.getCheckedKeys(true);
    t = t.filter((e) => e > 0), w.value = t;
  }, { crud: g, columns: k } = ie({ title: "人员", optShow: { ...q }, permission: { ...C }, crudApi: { ...ve }, sort: [], hasPagination: false, dataPath: "" }, S), { maxHeight: K } = ue({ wrapperBox: ".user", paginate: true, extraHeight: 90 }), Q = (t) => {
    D.value = t;
  };
  function B(t) {
    if (G(), !w.value.length) {
      T.warning("请至少选择一个员工");
      return;
    }
    const e = D.value.map((a) => a.id);
    if (!e.length) {
      T.warning("请至少选择一个项目");
      return;
    }
    h.value = true;
    const d = { ids: w.value, projectIds: e, isCover: !t };
    ee.confirm(t ? "提交后会将所有勾选的人员分别添加到所选项目中，确认后无法驳回，请谨慎操作" : "提交后会将所选项目原有成员全部清空，将勾选的人员作为所选项目的成员。确认后无法驳回，请谨慎操作！", { title: t ? "添加提交" : "覆盖提交", confirmButtonClass: t ? "user-manage-staff-add-button" : "user-manage-staff-cover-button", customClass: t ? "user-manage-staff-add-title" : "user-manage-staff-cover-title" }).then(async () => {
      await be(d), T.success("保存成功"), v.value = void 0, L(), g.toQuery();
    }).catch((a) => {
      console.log(a);
    }).finally(() => {
      h.value = false;
    });
  }
  return (t, e) => {
    const d = te, a = ae, U = j("common-button"), c = se, W = j("common-table"), E = le;
    return o(), Z("div", he, [i("div", ge, [f(d, { modelValue: v.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => v.value = r), class: "filter-item", placeholder: "输入部门/姓名搜索", style: { width: "270px", "margin-bottom": "20px" } }, null, 8, ["modelValue"]), i("div", ye, [O(f(a, { ref_key: "treeRef", ref: y, class: "filter-tree", data: $.value, "empty-text": "没有人员", props: I, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": z }, null, 8, ["data"]), [[E, J.data]])])]), i("div", we, [i("div", xe, [f(s(ce), { id: "header", ref: "header", onClearTableSelection: F }, null, 512), i("div", null, [s(H)(s(C).addSubmit) ? (o(), u(U, { key: 0, loading: h.value, class: "filter-item", size: "default", type: "success", onClick: e[1] || (e[1] = (r) => B("add")) }, { default: m(() => e[3] || (e[3] = [P(" 添加提交 ")])), _: 1, __: [3] }, 8, ["loading"])) : p("", true), s(H)(s(C).coverSubmit) ? (o(), u(U, { key: 1, loading: h.value, class: "filter-item", size: "default", type: "warning", onClick: e[2] || (e[2] = (r) => B()) }, { default: m(() => e[4] || (e[4] = [P(" 覆盖提交 ")])), _: 1, __: [4] }, 8, ["loading"])) : p("", true)])]), O((o(), u(W, { ref_key: "tableRef", ref: S, data: s(g).data, "empty-text": s(g).emptyText, "max-height": s(K), "row-key": (r) => r.id, onSelectionChange: Q }, { default: m(() => [f(c, { type: "selection", "reserve-selection": true, width: "55", align: "center" }), f(c, { label: "序号", type: "index", align: "center", width: "60" }), s(k).visible("serialNumber") ? (o(), u(c, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, "min-width": "130", align: "center", label: "合同编号" })) : p("", true), s(k).visible("name") ? (o(), u(c, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目", align: "center", "min-width": "250" }, { default: m((r) => [i("span", null, A(r.row.name), 1)]), _: 1 })) : p("", true), s(k).visible("businessType") ? (o(), u(c, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", "min-width": "100" }, { default: m((r) => [i("span", null, A(r.row.businessType && s(de).VL[r.row.businessType]), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "row-key"])), [[E, s(g).loading]])])]);
  };
} }, Le = re(ke, [["__scopeId", "data-v-0a547f66"]]);
export {
  Le as default
};
