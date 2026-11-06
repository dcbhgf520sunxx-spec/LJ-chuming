import { ref as o } from "vue";
import { reactive as ke } from "vue";
import { computed as xe } from "vue";
import { watch as H } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as d } from "vue";
import { withDirectives as J } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as O } from "vue";
import { unref as a } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as m } from "vue";
import { withKeys as te } from "vue";
import { ElMessageBox as we } from "element-plus";
import { ElMessage as Ce } from "element-plus";
import { ElInput as Ne } from "element-plus";
import { ElTree as je } from "element-plus";
import { ElTag as Te } from "element-plus";
import { ElTableColumn as Se } from "element-plus";
import { vLoading as Ue } from "element-plus";
import { l as ne, _ as Ve, ds as Be, o as Ee, x as Pe, i as Oe, G as z, c1 as ae, bN as se } from "../../../shared/runtime.js";
import { p as S } from "../../../modules/user-2de6904c.js";
function ze(D) {
  return ne({ url: "/api/project/listAllProject/user", method: "get", params: D });
}
function De(D) {
  return ne({ url: "/api/project/listAllProject/userUpdateProject", method: "post", data: D });
}
const Le = { get: ze };
const Re = { class: "app-container wrap" }, $e = { class: "wrap-left" }, Me = { style: { "max-height": "674px", "overflow-y": "auto" } }, Ae = { class: "wrap-right" }, Ie = { class: "wrap-right-herder" }, Ke = { class: "table-content" }, He = { class: "not-bound" }, qe = { key: 0, class: "table-null-text" }, Je = { key: 1 }, Qe = { class: "table-herder" }, Fe = { class: "bound" }, Ge = { key: 0, class: "table-null-text" }, We = { key: 1 }, Xe = { class: "table-herder" }, Ye = { __name: "index", setup(D) {
  const U = o(), L = o(), R = o(), Q = o([]), ie = o([]), $ = o(), h = o(), k = o(), b = o(), w = o([]), C = o([]), x = o(), y = o(), v = o([]), f = o([]), V = o([]), B = o([]), F = o(false), oe = { children: "children", label: "label", disabled: (l) => !l.isUser }, { userDeptTree: M } = Be(), ue = ke({ data: false }), re = xe(() => Q.value), { maxHeight: G } = Ee({ paginate: false, extraHeight: "140px" }), { crud: N, CRUD: W, columns: j } = Pe({ title: "人员绑定项目配置", permission: { ...S }, crudApi: { ...Le }, sort: [], hasPagination: false, queryOnPresenterCreated: false }, U);
  function I(l, e, i) {
    l.forEach((s) => {
      s.disabled = e, s.parentLabel = i, s.isUser || (s.id === 1 ? s.label = "<公司>" + s.label : s.label = "<部门>" + s.label, s.id = -s.id), s.children && I(s.children, e, s.label);
    });
  }
  function X() {
    let l = [], e = [];
    l = JSON.parse(JSON.stringify(M.value)), I(l, true), e = JSON.parse(JSON.stringify(M.value)), I(e, false), ie.value = l, Q.value = e;
  }
  function de() {
    const l = R.value.getCheckedNodes(true);
    h.value = l[0];
  }
  const ce = (l, e) => l ? e.label.indexOf(l) !== -1 || e.parentLabel && e.parentLabel.indexOf(l) !== -1 : true;
  function ve(l, e, i) {
    e && R.value.setCheckedKeys([l.id]), de();
  }
  function fe(l) {
    var e;
    v.value.forEach((i, s) => {
      i.id === l.id && v.value.splice(s, 1);
    }), f.value.unshift(l), T(), (e = U.value) == null || e.clearSelection();
  }
  function pe() {
    var l;
    V.value.forEach((e, i) => {
      v.value.forEach((s, E) => {
        e.id === s.id && v.value.splice(E, 1);
      });
    }), f.value.unshift(...V.value), T(), (l = U.value) == null || l.clearSelection(), V.value = [];
  }
  function me(l) {
    var e;
    f.value.forEach((i, s) => {
      i.id === l.id && f.value.splice(s, 1);
    }), v.value.unshift(l), (e = L.value) == null || e.clearSelection();
  }
  function be() {
    var l;
    B.value.forEach((e, i) => {
      f.value.forEach((s, E) => {
        e.id === s.id && f.value.splice(E, 1);
      });
    }), v.value.unshift(...B.value), B.value = [], (l = L.value) == null || l.clearSelection();
  }
  function ye(l) {
    V.value = l;
  }
  function _e(l) {
    B.value = l;
  }
  function T() {
    if (!b.value && !k.value) {
      w.value = v.value || [];
      return;
    }
    if (b.value && k.value) {
      w.value = v.value.filter((l) => l.status === k.value && (l.name.includes(b.value) || l.serialNumber.includes(b.value))) || [];
      return;
    }
    k.value && (w.value = v.value.filter((l) => l.status === k.value) || []), b.value && (w.value = v.value.filter((l) => l.name.includes(b.value) || l.serialNumber.includes(b.value)) || []);
  }
  function Y() {
    var l;
    b.value = void 0, k.value = void 0, T(), (l = U.value) == null || l.clearSelection();
  }
  function A() {
    if (!y.value && !x.value) {
      C.value = f.value || [];
      return;
    }
    if (y.value && x.value) {
      C.value = f.value.filter((l) => l.status === x.value && (l.name.includes(y.value) || l.serialNumber.includes(y.value))) || [];
      return;
    }
    x.value && (C.value = f.value.filter((l) => l.status === x.value) || []), y.value && (C.value = f.value.filter((l) => l.name.includes(y.value) || l.serialNumber.includes(y.value)) || []);
  }
  function Z() {
    var l;
    y.value = void 0, x.value = void 0, A(), (l = L.value) == null || l.clearSelection();
  }
  H(() => h.value, (l) => {
    l && N.toQuery();
  }, { deep: true }), H(() => $.value, (l) => {
    R.value.filter(l);
  }), H(M, (l) => {
    Oe(M.value) && X();
  }, { immediate: true, deep: true }), W.HOOK.beforeToQuery = () => {
    var l;
    N.query.userId = (l = h.value) == null ? void 0 : l.id;
  }, W.HOOK.handleRefresh = (l, e) => {
    v.value = e.data.noUser || [], w.value = e.data.noUser || [], f.value = e.data.user || [], C.value = e.data.user || [], Y(), Z();
  };
  function ge() {
    var e;
    const l = { projectAddIds: f.value.map((i) => i.id), projectDelIds: v.value.map((i) => i.id), userId: (e = h.value) == null ? void 0 : e.id };
    we.confirm("确认后无法驳回，请谨慎操作！", { title: "确认提交", confirmButtonClass: "person-bound-project-confirm-button", customClass: "person-bound-project-confirm-title" }).then(async () => {
      await De(l), Ce.success("保存成功"), $.value = void 0, X(), N.toQuery();
    }).catch((i) => {
      console.log(i);
    }).finally(() => {
      F.value = false;
    });
  }
  return (l, e) => {
    const i = Ne, s = je, E = Te, g = q("common-button"), ee = q("common-select"), p = Se, le = q("common-table"), K = Ue;
    return u(), P("div", Re, [n("div", $e, [d(i, { modelValue: $.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => $.value = t), class: "filter-item", placeholder: "输入部门/姓名搜索", style: { width: "270px", "margin-bottom": "20px" } }, null, 8, ["modelValue"]), n("div", Me, [J(d(s, { ref_key: "treeRef", ref: R, class: "filter-tree", data: re.value, "empty-text": "没有人员", props: oe, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": ce, onCheck: ve }, null, 8, ["data"]), [[K, ue.data]])])]), e[24] || (e[24] = n("div", { class: "parting-line" }, null, -1)), n("div", Ae, [n("div", Ie, [d(E, { class: "tip-tag", type: "success", size: "large", effect: "plain" }, { default: r(() => {
      var t;
      return [_(" 当前选择人员：" + O(((t = h.value) == null ? void 0 : t.label) || "-"), 1)];
    }), _: 1 }), a(z)(a(S).submit) ? (u(), c(g, { key: 0, loading: F.value, class: "filter-item", size: "default", type: "success", disabled: !h.value, onClick: e[1] || (e[1] = (t) => ge()) }, { default: r(() => e[12] || (e[12] = [_(" 确认提交 ")])), _: 1, __: [12] }, 8, ["loading", "disabled"])) : m("", true)]), n("div", Ke, [n("div", He, [e[17] || (e[17] = n("div", { class: "table-title" }, "未绑定项目预览列表", -1)), h.value ? (u(), P("div", Je, [n("div", Qe, [n("div", null, [d(ee, { modelValue: k.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => k.value = t), options: a(ae).ENUM, type: "enum", size: "default", class: "search-item", style: { width: "130px" }, clearable: "", placeholder: "选择项目状态", onChange: T }, null, 8, ["modelValue", "options"]), d(i, { modelValue: b.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => b.value = t), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目编号/名称", style: { width: "180px" }, class: "search-item", clearable: "", onKeyup: te(T, ["enter"]) }, null, 8, ["modelValue"]), d(g, { class: "filter-item", size: "default", icon: "el-icon-search", type: "success", onClick: e[4] || (e[4] = (t) => T()) }, { default: r(() => e[13] || (e[13] = [_(" 搜索 ")])), _: 1, __: [13] }), d(g, { class: "filter-item", size: "default", icon: "el-icon-refresh-left", type: "warning", onClick: e[5] || (e[5] = (t) => Y()) }, { default: r(() => e[14] || (e[14] = [_(" 重置 ")])), _: 1, __: [14] })]), a(z)(a(S).join) ? (u(), c(g, { key: 0, class: "filter-item", size: "default", type: "success", disabled: !V.value.length, onClick: e[6] || (e[6] = (t) => pe()) }, { default: r(() => e[15] || (e[15] = [_(" 批量加入 ")])), _: 1, __: [15] }, 8, ["disabled"])) : m("", true)]), J((u(), c(le, { ref_key: "notBoundTableRef", ref: U, data: w.value, "max-height": a(G), "row-key": "id", onSelectionChange: ye }, { default: r(() => [d(p, { type: "selection", "reserve-selection": true, width: "55", align: "center" }), d(p, { label: "序号", type: "index", align: "center", width: "60" }), a(j).visible("serialNumber") ? (u(), c(p, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "合同编号" })) : m("", true), a(j).visible("name") ? (u(), c(p, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目", align: "center" }, { default: r((t) => [n("span", null, O(t.row.name), 1)]), _: 1 })) : m("", true), a(j).visible("businessType") ? (u(), c(p, { key: "businessType", prop: "businessType", label: "业务类型", align: "center" }, { default: r((t) => [n("span", null, O(t.row.businessType && a(se).VL[t.row.businessType]), 1)]), _: 1 })) : m("", true), a(z)(a(S).join) ? (u(), c(p, { key: 3, label: "操作", align: "center" }, { default: r((t) => [d(g, { class: "filter-item", size: "default", type: "success", onClick: (he) => fe(t.row) }, { default: r(() => e[16] || (e[16] = [_(" 加入 ")])), _: 2, __: [16] }, 1032, ["onClick"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "max-height"])), [[K, a(N).loading]])])) : (u(), P("div", qe, "请先在左侧列表选择人员！"))]), e[23] || (e[23] = n("div", { class: "parting-line" }, null, -1)), n("div", Fe, [e[22] || (e[22] = n("div", { class: "table-title" }, "已绑定项目预览列表", -1)), h.value ? (u(), P("div", We, [n("div", Xe, [n("div", null, [d(ee, { modelValue: x.value, "onUpdate:modelValue": e[7] || (e[7] = (t) => x.value = t), options: a(ae).ENUM, type: "enum", size: "default", class: "search-item", style: { width: "130px" }, clearable: "", placeholder: "选择项目状态", onChange: A }, null, 8, ["modelValue", "options"]), d(i, { modelValue: y.value, "onUpdate:modelValue": e[8] || (e[8] = (t) => y.value = t), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目编号/名称", style: { width: "180px" }, class: "search-item", clearable: "", onKeyup: te(A, ["enter"]) }, null, 8, ["modelValue"]), d(g, { class: "filter-item", size: "default", icon: "el-icon-search", type: "success", onClick: e[9] || (e[9] = (t) => A()) }, { default: r(() => e[18] || (e[18] = [_(" 搜索 ")])), _: 1, __: [18] }), d(g, { class: "filter-item", size: "default", icon: "el-icon-refresh-left", type: "warning", onClick: e[10] || (e[10] = (t) => Z()) }, { default: r(() => e[19] || (e[19] = [_(" 重置 ")])), _: 1, __: [19] })]), a(z)(a(S).remove) ? (u(), c(g, { key: 0, class: "filter-item", size: "default", type: "danger", disabled: !B.value.length, onClick: e[11] || (e[11] = (t) => be()) }, { default: r(() => e[20] || (e[20] = [_(" 批量移出 ")])), _: 1, __: [20] }, 8, ["disabled"])) : m("", true)]), J((u(), c(le, { ref_key: "boundTableRef", ref: L, data: C.value, "empty-text": a(N).emptyText, "max-height": a(G), "row-key": "id", onSelectionChange: _e }, { default: r(() => [d(p, { type: "selection", "reserve-selection": true, width: "55", align: "center" }), d(p, { label: "序号", type: "index", align: "center", width: "60" }), a(j).visible("serialNumber") ? (u(), c(p, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "合同编号" })) : m("", true), a(j).visible("name") ? (u(), c(p, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目", align: "center" }, { default: r((t) => [n("span", null, O(t.row.name), 1)]), _: 1 })) : m("", true), a(j).visible("businessType") ? (u(), c(p, { key: "businessType", prop: "businessType", label: "业务类型", align: "center" }, { default: r((t) => [n("span", null, O(t.row.businessType && a(se).VL[t.row.businessType]), 1)]), _: 1 })) : m("", true), a(z)(a(S).remove) ? (u(), c(p, { key: 3, label: "操作", align: "center" }, { default: r((t) => [d(g, { class: "filter-item", size: "default", type: "danger", onClick: (he) => me(t.row) }, { default: r(() => e[21] || (e[21] = [_(" 移出 ")])), _: 2, __: [21] }, 1032, ["onClick"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, a(N).loading]])])) : (u(), P("div", Ge, "请先在左侧列表选择人员！"))])])])]);
  };
} }, al = Ve(Ye, [["__scopeId", "data-v-17c42445"]]);
export {
  al as default
};
