import { computed as ne } from "vue";
import { ref as r } from "vue";
import { watch as j } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as R } from "vue";
import { createBlock as U } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as t } from "vue";
import { unref as y } from "vue";
import { createTextVNode as x } from "vue";
import { withDirectives as ue } from "vue";
import { ElMessage as N } from "element-plus";
import { nextTick as re } from "vue";
import { ElInput as ie } from "element-plus";
import { ElCheckbox as se } from "element-plus";
import { Plus as de } from "@element-plus/icons-vue";
import { ElIcon as ce } from "element-plus";
import { ElBadge as me } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElPagination as fe } from "element-plus";
import { vLoading as ve } from "element-plus";
import { c as ge, g as be } from "./create-form.vue.js";
import { _ as he, o as _e, bZ as Ie, b as we, kb as ye } from "../../../../../shared/runtime.js";
import { _ as xe } from "../../../../../modules/project-select-94bb5bbd.js";
import Ve from "./select-all-dialog.vue.js";
const Ce = { class: "search-section" }, Se = { class: "search-form" }, je = { class: "action-bar" }, Ne = { class: "action-right" }, ze = { class: "table-section" }, ke = "暂无数据", Ae = { __name: "select-drawer", props: { modelValue: { type: Boolean, default: false }, projectId: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "confirm"], setup(D, { emit: E }) {
  const V = D, z = E, g = ne({ get: () => V.modelValue, set: (a) => z("update:modelValue", a) }), T = r(), C = r(), S = r(false), p = r(false), b = r(false), d = r(false), f = r([]), n = r([]), h = r(1), _ = r(null), I = r([]), k = r(void 0), l = r({ projectId: V.projectId, monomerId: void 0, areaId: void 0, serialNumber: "", paintTechnologyId: void 0 }), u = r({ pageNumber: 1, pageSize: 20, total: 0 }), { maxHeight: B } = _e({ wrapperBox: ".paint-technology-select-drawer", paginate: true, extraHeight: 80 });
  function F(a) {
    l.value.projectId = a, l.value.monomerId = void 0, l.value.areaId = void 0, n.value = [], a ? c() : (I.value = [], u.value.total = 0);
  }
  function q() {
    u.value.pageNumber = 1, c();
  }
  function H() {
    l.value.monomerId = void 0, l.value.areaId = void 0, l.value.serialNumber = "", u.value.pageNumber = 1, c();
  }
  function L(a) {
    var e;
    a ? b.value = true : (p.value = false, (e = C.value) == null || e.clearSelection());
  }
  function M(a, e) {
    p.value = false, b.value = false, n.value = [], h.value = a, k.value = e, _.value = null, d.value = true;
  }
  j(b, (a) => {
    a || (p.value = false);
  });
  function P(a) {
    f.value = a;
  }
  function $() {
    var e;
    if (f.value.length === 0) {
      N.warning("请先选择构件");
      return;
    }
    const a = f.value.filter((m) => !n.value.some((v) => v.artifactId === m.artifactId));
    n.value = [...n.value, ...a], (e = C.value) == null || e.clearSelection(), f.value = [], N.success(`已添加 ${a.length} 个构件`);
  }
  function Q() {
    if (n.value.length === 0) {
      N.warning("请先添加构件");
      return;
    }
    h.value = 1, _.value = null, d.value = true;
  }
  function Z() {
    d.value = false, n.value = [], h.value = 1, _.value = null, z("confirm", [], void 0), g.value = false;
  }
  function G(a) {
    return !n.value.some((m) => m.artifactId === a.artifactId);
  }
  function J(a) {
    const e = n.value.findIndex((m) => m.artifactId === a);
    e > -1 && (n.value.splice(e, 1), re(() => {
    }));
  }
  function K() {
    if (d.value) {
      d.value = false;
      return;
    }
    g.value = false, n.value = [], f.value = [], h.value = 1, _.value = null, p.value = false;
  }
  function O(a) {
    u.value.pageSize = a, u.value.pageNumber = 1, c();
  }
  function W(a) {
    u.value.pageNumber = a, c();
  }
  async function c() {
    S.value = true;
    try {
      const a = { projectId: l.value.projectId, monomerId: l.value.monomerId, areaId: l.value.areaId, serialNumber: l.value.serialNumber, paintTechnologyId: l.value.paintTechnologyId, pageNumber: u.value.pageNumber, pageSize: u.value.pageSize }, e = await be(a);
      I.value = (e == null ? void 0 : e.content) || [], u.value.total = (e == null ? void 0 : e.totalElements) || 0;
    } catch (a) {
      console.log("获取构件列表失败", a), I.value = [], u.value.total = 0;
    } finally {
      S.value = false;
    }
  }
  return j(() => V.projectId, (a) => {
    l.value.projectId = a, a && c();
  }, { immediate: true }), j(() => g.value, (a) => {
    a && c();
  }), (a, e) => {
    const m = ie, v = A("common-button"), X = se, Y = de, ee = ce, ae = me, s = pe, le = A("common-table"), te = fe, oe = ve;
    return R(), U(ye, { ref_key: "drawerRef", ref: T, modelValue: g.value, "onUpdate:modelValue": e[9] || (e[9] = (o) => g.value = o), title: "选择构件", "show-close": true, beforeClose: K, "wrapper-closable": false, size: "100%", "custom-class": "paint-technology-select-drawer" }, { titleRight: i(() => e[10] || (e[10] = [])), content: i(() => [w("div", Ce, [w("div", Se, [t(y(xe), { modelValue: l.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (o) => l.value.projectId = o), clearable: false, class: "filter-item", style: { width: "270px" }, placeholder: "选择项目", onChange: F }, null, 8, ["modelValue"]), t(y(Ie), { "monomer-id": l.value.monomerId, "onUpdate:monomerId": e[1] || (e[1] = (o) => l.value.monomerId = o), "area-id": l.value.areaId, "onUpdate:areaId": e[2] || (e[2] = (o) => l.value.areaId = o), "project-id": l.value.projectId, clearable: "", "area-clearable": "" }, null, 8, ["monomer-id", "area-id", "project-id"]), t(m, { modelValue: l.value.serialNumber, "onUpdate:modelValue": e[3] || (e[3] = (o) => l.value.serialNumber = o), size: "default", placeholder: "编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), t(v, { type: "primary", size: "default", onClick: q }, { default: i(() => e[11] || (e[11] = [x("搜索")])), _: 1, __: [11] }), t(v, { size: "default", style: { "margin-left": "0px" }, onClick: H }, { default: i(() => e[12] || (e[12] = [x("重置")])), _: 1, __: [12] })]), w("div", je, [w("div", Ne, [t(X, { modelValue: p.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => p.value = o), onChange: L, disabled: y(we)(l.value.projectId) || I.value.length === 0 }, { default: i(() => e[13] || (e[13] = [x(" 全选 ")])), _: 1, __: [13] }, 8, ["modelValue", "disabled"]), t(v, { type: "success", size: "default", disabled: f.value.length === 0, onClick: $, style: { "margin-left": "10px" } }, { default: i(() => [t(ee, null, { default: i(() => [t(Y)]), _: 1 })]), _: 1 }, 8, ["disabled"]), t(ae, { value: n.value.length, hidden: n.value.length === 0, class: "badge-item" }, { default: i(() => [t(v, { type: "primary", size: "default", disabled: n.value.length === 0, onClick: Q }, { default: i(() => e[14] || (e[14] = [x(" 数量汇总 ")])), _: 1, __: [14] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])])])]), w("div", ze, [ue((R(), U(le, { ref_key: "tableRef", ref: C, data: I.value, "empty-text": ke, "max-height": y(B), "return-source-data": "", style: { width: "100%" }, onSelectionChange: P }, { default: i(() => [t(s, { type: "selection", width: "55", selectable: G }), t(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s, { prop: "monomer.name", label: "单体", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(s, { prop: "area.name", label: "区域", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(s, { prop: "name", label: "名称", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(s, { prop: "serialNumber", label: "编号", align: "center", "min-width": "140px", "show-overflow-tooltip": true }), t(s, { prop: "specification", label: "规格", align: "center", "min-width": "120px", "show-overflow-tooltip": true }), t(s, { prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), t(s, { prop: "totalArea", label: "面积", align: "center", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height"])), [[oe, S.value]]), t(te, { "current-page": u.value.pageNumber, "onUpdate:currentPage": e[5] || (e[5] = (o) => u.value.pageNumber = o), "page-size": u.value.pageSize, "onUpdate:pageSize": e[6] || (e[6] = (o) => u.value.pageSize = o), "page-sizes": [10, 20, 50, 100], total: u.value.total, layout: "total, sizes, prev, pager, next, jumper", onSizeChange: O, onCurrentChange: W, style: { "margin-top": "15px", "text-align": "right" } }, null, 8, ["current-page", "page-size", "total"])]), t(Ve, { modelValue: b.value, "onUpdate:modelValue": e[7] || (e[7] = (o) => b.value = o), "project-id": l.value.projectId, onConfirm: M }, null, 8, ["modelValue", "project-id"]), t(ge, { modelValue: d.value, "onUpdate:modelValue": e[8] || (e[8] = (o) => d.value = o), "form-data": _.value, "artifact-list": n.value, "range-type": h.value, "project-id": l.value.projectId, "monomer-id": k.value, onSuccess: Z, onArtifactRemoved: J }, null, 8, ["modelValue", "form-data", "artifact-list", "range-type", "project-id", "monomer-id"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, qe = he(Ae, [["__scopeId", "data-v-ff4df27c"]]);
export {
  qe as default
};
