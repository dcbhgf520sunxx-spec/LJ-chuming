import { useStore as q } from "vuex";
import { ref as h } from "vue";
import { provide as _ } from "vue";
import { watch as L } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as g } from "vue";
import { unref as o } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as r } from "vue";
import { withCtx as P } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as $ } from "vue";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as K } from "../../../../modules/mes-ship-receipt-ae6ae43f.js";
import { _ as J, m as W, x as X, Bq as j, o as Y, ky as Z, i as w, G as ee, P as te } from "../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
import ae from "./module/review.vue.js";
import le from "./module/detail.vue.js";
import "./module/outbound-handle-table.vue.js";
import "./module/outbound-handling-form/index.vue.js";
import "./module/outbound-handling-form/module/steel-plate.vue.js";
import "./module/outbound-handling-form/components/common-form-item.vue.js";
import "./module/outbound-handling-form/components/produce-form.vue.js";
import "./module/outbound-handling-form/components/common-material-info.vue.js";
import "./module/outbound-handling-form/module/section-steel.vue.js";
import "./module/outbound-handling-form/module/steel-coil.vue.js";
import "./module/outbound-handling-form/module/aux-mat.vue.js";
import "./module/outbound-handling-form/module/gas.vue.js";
import "./module/outbound-handling-form/module/other.vue.js";
import "./module/submit-review.vue.js";
import "./module/outbound-detail.vue.js";
const re = { class: "app-container" }, ie = { class: "head-container" }, ne = { __name: "index", setup(se) {
  const { globalProject: k, globalProjectId: C } = W(["globalProject", "globalProjectId"]), V = q(), A = { add: false, edit: false, del: false, download: false }, u = h(), R = h([]), b = h(false), m = h({}), S = h({}), y = h(false);
  _("globalProject", k), _("handlingData", R), _("globalProjectId", C);
  const { crud: i, columns: p, CRUD: D } = X({ title: "配套件清单", sort: ["id.desc"], permission: { ...j }, optShow: { ...A }, requiredQuery: ["projectId", "hasInit", "relationType"], invisibleColumns: [], crudApi: { ...K }, hasPagination: true }, u), { maxHeight: N } = Y({ wrapperBox: ".plan-standard-part", paginate: true, extraHeight: 40 }), E = h([["useProperty", ["parse-enum", Z]], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]);
  L(() => V.state.approval_list.isRefresh, (a) => {
    a && i.toQuery();
  }, { deep: true });
  function T(a) {
    if (a) {
      const t = i.data.filter((e) => e.mete > 0);
      if (w(t)) {
        m.value = t == null ? void 0 : t[0];
        const e = m.value.useProperty, d = t.filter((n) => n.useProperty === e);
        i.data.forEach((n) => {
          var f, s;
          d.findIndex((v) => v.id === n.id) > -1 ? (f = u.value) == null || f.toggleRowSelection(n, true) : (s = u.value) == null || s.toggleRowSelection(n, false);
        });
      }
    } else i.data.forEach((t) => {
      var e;
      (e = u.value) == null || e.toggleRowSelection(t, false);
    });
  }
  function B(a) {
    const t = w(a.sourceRow) ? a.sourceRow : a;
    let e;
    return w(m.value) && (e = m.value.useProperty), (e ? t.useProperty === e : true) && a.mete > 0;
  }
  function U() {
    b.value = true;
  }
  function H(a) {
    m.value = a[0], R.value = a;
  }
  function G(a) {
    if (w(a)) {
      const t = i.data.filter((e) => e.mete > e.totalCargoNetweight);
      if (w(t)) {
        m.value = t == null ? void 0 : t[0];
        const e = m.value.useProperty, d = t.filter((n) => n.useProperty === e);
        i.data.forEach((n) => {
          var f, s;
          d.findIndex((v) => v.id === n.id) > -1 ? (f = u.value) == null || f.toggleRowSelection(n, true) : (s = u.value) == null || s.toggleRowSelection(n, false);
        });
      } else i.data.forEach((e) => {
        var d;
        (d = u.value) == null || d.toggleRowSelection(e, false);
      });
    } else i.data.forEach((t) => {
      var e;
      (e = u.value) == null || e.toggleRowSelection(t, false);
    });
  }
  function M(a) {
    S.value = a, y.value = a;
  }
  return D.HOOK.handleRefresh = (a, t) => {
    t.data.content.map((e) => (e.projectId = e.project.id, w(e.monomer) && (e.monomerId = e.monomer.id), w(e.area) && (e.areaId = e.area.id), e));
  }, (a, t) => {
    const e = z, d = I("common-button"), n = I("common-table"), f = F;
    return l(), O("div", re, [x("div", ie, [g(o(oe), { "project-id": o(C), currentGlobalProject: o(k), onToHandle: U, onCheckAll: T }, null, 8, ["project-id", "currentGlobalProject"])]), x("div", null, [Q((l(), r(n, { ref_key: "tableRef", ref: u, data: o(i).data, "empty-text": o(i).emptyText, "data-format": E.value, "max-height": o(N), style: { width: "100%" }, onSortChange: o(i).handleSortChange, onSelectAll: G, onSelectionChange: H }, { default: P(() => [g(e, { key: "selection", type: "selection", width: "55", selectable: B }), g(e, { label: "序号", type: "index", align: "center", width: "55" }), o(p).visible("monomer.name") ? (l(), r(e, { key: 0, prop: "monomer.name", label: "单体", align: "center", "min-width": "100", "show-overflow-tooltip": true })) : c("", true), o(p).visible("area.name") ? (l(), r(e, { key: 1, prop: "area.name", label: "区域", align: "center", "min-width": "100", "show-overflow-tooltip": true })) : c("", true), o(p).visible("name") ? (l(), r(e, { key: 2, prop: "name", label: "名称", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : c("", true), o(p).visible("specification") ? (l(), r(e, { key: 3, "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", "min-width": "150px" })) : c("", true), o(p).visible("accountingUnit") ? (l(), r(e, { key: 4, "show-overflow-tooltip": true, prop: "accountingUnit", label: `核算
单位`, align: "center", width: "80px" })) : c("", true), o(p).visible("mete") ? (l(), r(e, { key: 5, "show-overflow-tooltip": true, prop: "mete", label: "核算量", align: "center", "min-width": "120px" })) : c("", true), o(p).visible("boolArtifactImport") ? (l(), r(e, { key: 6, "show-overflow-tooltip": true, prop: "boolArtifactImport", label: "来源", align: "center", "min-width": "120px" }, { default: P(({ row: s }) => [x("span", null, $(s.boolArtifactImport ? "构零件清单" : "创建"), 1)]), _: 1 })) : c("", true), o(p).visible("useProperty") ? (l(), r(e, { key: 7, "show-overflow-tooltip": true, prop: "useProperty", label: "使用范围", align: "center", width: "120px" })) : c("", true), o(p).visible("userName") ? (l(), r(e, { key: 8, "show-overflow-tooltip": true, prop: "userName", label: "导入人", align: "center", width: "100px" })) : c("", true), o(p).visible("createTime") ? (l(), r(e, { key: 9, "show-overflow-tooltip": true, prop: "createTime", label: "导入时间", align: "center", width: "120px" })) : c("", true), o(p).visible("remark") ? (l(), r(e, { key: 10, prop: "remark", label: "备注", "show-overflow-tooltip": true, align: "center" })) : c("", true), o(p).visible("totalCargoNetweight") ? (l(), r(e, { key: 11, prop: "totalCargoNetweight", label: "已出库量", "show-overflow-tooltip": true, align: "center" })) : c("", true), g(e, { label: "操作", width: "80px", align: "center", fixed: "right" }, { default: P(({ row: s }) => [o(ee)(o(j).detail) ? (l(), r(d, { key: 0, onClick: (v) => M(s), icon: "el-icon-view", size: "default", type: "info" }, null, 8, ["onClick"])) : c("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSortChange"])), [[f, o(i).loading]])]), g(o(te)), g(ae, { modelValue: b.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => b.value = s), onRefresh: o(i).refresh }, null, 8, ["modelValue", "onRefresh"]), g(le, { modelValue: y.value, "onUpdate:modelValue": t[1] || (t[1] = (s) => y.value = s), data: S.value }, null, 8, ["modelValue", "data"])]);
  };
} }, Ie = J(ne, [["__scopeId", "data-v-01fa3152"]]);
export {
  Ie as default
};
