import { useStore as O } from "vuex";
import { ref as m } from "vue";
import { provide as I } from "vue";
import { computed as M } from "vue";
import { watch as H } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as S } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as G } from "vue";
import { toDisplayString as Y } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElTag as z } from "element-plus";
import { vLoading as K } from "element-plus";
import { hg as J, x as W, xu as y, xv as X, o as Z, bv as ee, cP as te, xw as ae, w5 as k, G as oe, P as ie, xx as se, ba as le, jN as re, D as N } from "../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import "./module/form/index.vue.js";
import "./module/form/components/steel-plate-table.vue.js";
import "./module/form/components/section-steel-table.vue.js";
import "./module/form/components/steel-coil-table.vue.js";
import "./module/form/components/other-steel-material-table.vue.js";
import "./module/form/components/auxiliary-material.vue.js";
import "./module/form/components/gas-table.vue.js";
import "./module/form/components/other-table.vue.js";
import "./module/form/submit-preview.vue.js";
const ce = { class: "app-container" }, xe = { __name: "index", setup(ue) {
  const d = O(), C = { add: false, edit: false, del: false, download: false }, b = m(), f = m({}), _ = m({}), w = m(false), g = m("detail");
  I("classifyNameObj", f);
  const E = M(() => [["projects", ["parse-project"]], ["deficitType", ["parse-enum", J]], ["createTime", ["parse-time"]], ["reviewTime", ["parse-time"]]]), { CRUD: D, crud: u, columns: l } = W({ title: "盘亏办理", sort: ["id.desc"], invisibleColumns: [], permission: { ...y }, optShow: { ...C }, crudApi: X }, b), { maxHeight: V } = Z({ paginate: true });
  function R(a) {
    return le(a, { props: ["quantity", ["mete", re.weight.precision], ["amount", N.YUAN], ["amountExcludingVAT", N.YUAN]], toThousandFields: ["amount", "amountExcludingVAT"] });
  }
  D.HOOK.handleRefresh = async (a, { data: r }) => {
    r.content.map((t) => {
      const v = ee.getBits(te.ENUM, t.basicClass, "L");
      t.typeText = v.join(" | ");
    });
  }, T();
  async function T() {
    f.value = {};
    try {
      const a = await ae();
      f.value = a || {}, await d.dispatch("approval_list/fetchApprovalNum");
    } catch (a) {
      console.log("获取库存对应物料种类名称", a);
    }
  }
  function j(a, r) {
    g.value = r, _.value = a, w.value = true;
  }
  function A() {
    T(), u.toQuery();
  }
  return H(() => d.state.approval_list.isRefresh, (a) => {
    a && u.toQuery();
  }, { deep: true }), Q(async () => {
    await d.dispatch("wms/fetchSteelDensityCfg");
  }), (a, r) => {
    const t = $, v = z, L = x("common-button"), U = x("common-table"), P = q("permission"), B = K;
    return o(), F("div", ce, [c(ne, { onSuccess: A }), S((o(), i(U, { ref_key: "tableRef", ref: b, data: e(u).data, "data-format": E.value, "max-height": e(V), "summary-method": R, "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: p(() => [c(t, { align: "center", label: "序号", type: "index", width: "60" }), e(l).visible("serialNumber") ? (o(), i(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "盘亏单号", "min-width": "100", prop: "serialNumber" })) : s("", true), e(l).visible("typeText") ? (o(), i(t, { key: "typeText", "show-overflow-tooltip": true, align: "left", label: "物料种类", "min-width": "100", prop: "typeText" })) : s("", true), e(l).visible("projects") ? (o(), i(t, { key: "projects", "show-overflow-tooltip": true, align: "left", label: "关联项目", "min-width": "100", prop: "projects" })) : s("", true), e(l).visible("deficitType") ? (o(), i(t, { key: "deficitType", "show-overflow-tooltip": true, align: "left", label: "成本归属", "min-width": "100", prop: "deficitType" })) : s("", true), e(l).visible("createTime") ? (o(), i(t, { key: "createTime", "show-overflow-tooltip": true, align: "left", label: "申请时间", prop: "createTime", width: "150" })) : s("", true), e(l).visible("reviewTime") ? (o(), i(t, { key: "reviewTime", "show-overflow-tooltip": true, align: "left", label: "审核通过时间", prop: "createTime", width: "150" })) : s("", true), e(l).visible("applicantName") ? (o(), i(t, { key: "applicantName", "show-overflow-tooltip": true, align: "left", label: "申请人", "min-width": "100", prop: "applicantName" })) : s("", true), e(l).visible("reviewStatus") ? (o(), i(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", label: "审核状态", prop: "reviewStatus", width: "100" }, { default: p(({ row: { sourceRow: n } }) => {
      var h;
      return [c(v, { type: (h = e(k).V[n.reviewStatus]) == null ? void 0 : h.TAG }, { default: p(() => [G(Y(e(k).VL[n.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : s("", true), e(oe)([...e(y).detail]) ? (o(), i(t, { key: 8, align: "center", label: "操作", width: "170px" }, { default: p(({ row: { sourceRow: n } }) => [S(c(L, { icon: "el-icon-view", size: "default", type: "primary", onClick: (h) => j(n, "detail") }, null, 8, ["onClick"]), [[P, e(y).detail]])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[B, e(u).loading]]), c(e(ie)), c(se, { modelValue: w.value, "onUpdate:modelValue": r[0] || (r[0] = (n) => w.value = n), form: _.value, submitType: g.value, onSuccess: e(u).toQuery }, null, 8, ["modelValue", "form", "submitType", "onSuccess"])]);
  };
} };
export {
  xe as default
};
