import { useStore as $ } from "vuex";
import { ref as b } from "vue";
import { watch as H } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as p } from "vue";
import { ElMessageBox as q } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElPopover as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as Y, jY as J, uP as y, x as X, w0 as v, w1 as Z, o as ee, bv as te, cP as ae, z as oe, G as R, vd as f, oz as se, an as ie, P as ne, w3 as re, b as ce, lP as pe, w4 as de, i as ue, jP as T } from "../../../shared/runtime.js";
import me from "./module/header.vue.js";
import he from "./module/track-drawer.vue.js";
import "../../../modules/use-approval-cfg-0a67817c.js";
import "../components/audit-records.vue.js";
import "./module/application/components/temporary-storage.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
const fe = { class: "app-container" }, _e = { key: 0 }, be = { key: 0 }, ye = { key: 1 }, we = { key: 1 }, ge = { key: 1 }, ve = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, Ce = { __name: "index", setup(Te) {
  J();
  const D = $(), M = { add: true, edit: false, del: false, download: false }, S = b(), A = b([["project", ["parse-project", { onlyShortName: true }]], ["dataStatus", ["parse-enum", y, { f: "L" }]], ["dataStatusTag", ["parse-enum", y, { f: "T" }], { source: "dataStatus" }], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: P, crud: u, columns: c } = X({ title: "材料申购", permission: { ...v }, invisibleColumns: [], crudApi: { ...Z }, optShow: { ...M } }, S), { maxHeight: j } = ee({ paginate: true }), N = b(false), U = b({}), O = b();
  P.HOOK.handleRefresh = (s, { data: d }) => {
    d.content.forEach((a) => {
      var g;
      const w = te.getBits(ae.ENUM, a.materialType, "L");
      a.typeText = w.join(" | "), a.inboundMete = a.inboundMete || 0, a.projectNames = [], (g = a.projectInfos) == null || g.forEach((C) => {
        a.projectNames.push(oe(C));
      }), a.projectNames = a.projectNames.join(",");
    });
  };
  async function F(s) {
    s.loading = true;
    try {
      ce(s.wmsApproveRecordFlowDTO) && (s.wmsApproveRecordFlowDTO = await pe(s.approveRecordIdNow));
    } catch (d) {
      console.log(d, "获取失败");
    } finally {
      s.loading = false;
    }
  }
  function B(s) {
    if (s.purchaseCreationState) {
      const d = [{ id: s.id, purchaseCreationState: s.purchaseCreationState }];
      q.confirm("是否要修改采购状态?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", closeOnClickModal: false }).then(async () => {
        await de(d), z({ type: "success", message: "修改成功" });
      }).finally(() => {
        u.refresh();
      });
    }
  }
  function L(s) {
    if (ue(u.selections)) {
      if (u.selections[0].materialType === T.MANUFACTURED.V) {
        if (!(s.basicClass & T.MANUFACTURED.V)) return false;
      } else if (s.basicClass & T.MANUFACTURED.V) return false;
    }
    return true;
  }
  return H(() => D.state.approval_list.isRefresh, (s) => {
    s && u.toQuery();
  }, { deep: true }), (s, d) => {
    const a = K, w = G, g = E("common-select"), C = Q, I = E("common-table"), k = W;
    return o(), m("div", fe, [l(t(me)), V((o(), i(I, { ref_key: "tableRef", ref: S, data: t(u).data, "data-format": A.value, "max-height": t(j), class: "hidden-table-check-all", style: { width: "100%" }, onSelectionChange: t(u).selectionChangeHandler }, { default: n(() => [l(a, { selectable: L, align: "center", fixed: "left", type: "selection", width: "55" }), l(a, { align: "center", label: "序号", type: "index", width: "55" }), t(c).visible("createTime") ? (o(), i(a, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : r("", true), t(c).visible("departmentName") ? (o(), i(a, { key: "departmentName", align: "center", label: "部门", prop: "departmentName", "show-overflow-tooltip": "", width: "120" })) : r("", true), t(c).visible("applicantName") ? (o(), i(a, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", "show-overflow-tooltip": "", width: "100" })) : r("", true), t(c).visible("projectNames") ? (o(), i(a, { key: "projectNames", align: "left", label: "项目", "min-width": "120", prop: "projectNames", "show-overflow-tooltip": "" }, { default: n(({ row: e }) => [h(p(e.projectNames || "-"), 1)]), _: 1 })) : r("", true), t(c).visible("branchCompany.name") ? (o(), i(a, { key: "branchCompany.name", align: "left", label: "申购单位", "min-width": "120", prop: "branchCompany.name", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: e } }) => {
      var _;
      return [h(p(((_ = e.branchCompany) == null ? void 0 : _.name) || "-"), 1)];
    }), _: 1 })) : r("", true), t(c).visible("serialNumber") ? (o(), i(a, { key: "serialNumber", align: "left", label: "申购编号", "min-width": "100", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), t(c).visible("typeText") ? (o(), i(a, { key: "typeText", align: "center", label: "材料分类", "min-width": "100", prop: "typeText", "show-overflow-tooltip": "" }, { default: n(({ row: e }) => [h(p(e.typeText || "-"), 1)]), _: 1 })) : r("", true), l(a, { align: "center", label: "采购状态", prop: "purchaseCreationState", width: "120" }, { default: n(({ row: { sourceRow: e } }) => {
      var _;
      return [!t(R)(t(v).procurementStatus) || e.purchaseCreationState === t(f).COMPLETED.V || e.purchaseCreationState === t(f).NOT_STARTED.V ? (o(), m("div", _e, [e.purchaseCreationState ? (o(), m("div", be, [e.dataStatus !== t(y).PASSED.L ? (o(), i(w, { key: 0, type: (_ = t(f).V[e.purchaseCreationState]) == null ? void 0 : _.T, effect: "plain" }, { default: n(() => [h(p(t(f).VL[e.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : r("", true)])) : (o(), m("span", ye, "-"))])) : (o(), m("div", we, [e.purchaseCreationState ? (o(), i(g, { key: 0, modelValue: e.purchaseCreationState, "onUpdate:modelValue": (x) => e.purchaseCreationState = x, disabled: e.dataStatus === t(y).INVALID.V || e.dataStatus === t(y).VOIDED.V, disabledVal: [t(f).NOT_STARTED.V], options: t(f).ENUM, unshowOptions: [t(f).NOT_STARTED.K], placeholder: "请选择采购类型", type: "enum", onChange: (x) => B(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledVal", "options", "unshowOptions", "onChange"])) : (o(), m("span", ge, "-"))]))];
    }), _: 1 }), t(c).visible("havePurchasedMete") ? (o(), i(a, { key: "havePurchasedMete", label: "已采购量/未采购量", prop: "havePurchasedMete", "show-overflow-tooltip": "", width: "150" }, { default: n(({ row: { sourceRow: e } }) => [h(p(e.havePurchasedMete || "-") + " / " + p(e.unPurchaseMete || "-") + " " + p(e.meteUnit ? `(${e.meteUnit})` : ""), 1)]), _: 1 })) : r("", true), t(c).visible("inboundMete") ? (o(), i(a, { key: "inboundMete", label: "实际入库量", prop: "inboundMete", "show-overflow-tooltip": "", "min-width": "100" }, { default: n(({ row: { sourceRow: e } }) => [h(p(e.inboundMete || "-") + p(e.meteUnit ? `(${e.meteUnit})` : ""), 1)]), _: 1 })) : r("", true), t(c).visible("dataStatus") ? (o(), i(a, { key: "dataStatus", align: "center", label: "审批状态", "show-overflow-tooltip": "", width: "90" }, { default: n(({ row: e }) => [l(C, { width: 400, placement: "top", trigger: "click", onShow: (_) => F(e) }, { reference: n(() => [l(w, { type: e.dataStatusTag, effect: "plain", size: "default", style: { cursor: "pointer" } }, { default: n(() => [h(p(e.dataStatus), 1)]), _: 2 }, 1032, ["type"])]), default: n(() => [V((o(), m("div", ve, [l(se, { data: e.wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[k, e.loading]])]), _: 2 }, 1032, ["onShow"])]), _: 1 })) : r("", true), t(R)([...t(v).detail]) ? (o(), i(a, { key: 10, align: "center", fixed: "right", label: "操作", width: "70" }, { default: n(({ row: { sourceRow: e } }) => [l(ie, { data: { id: e.id }, permission: t(v), "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data", "permission"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[k, t(u).loading]]), l(t(ne)), l(re, { "show-buttom": "" }), l(t(he), { visible: N.value, "onUpdate:visible": d[0] || (d[0] = (e) => N.value = e), info: U.value, showType: O.value }, null, 8, ["visible", "info", "showType"])]);
  };
} }, Ae = Y(Ce, [["__scopeId", "data-v-eb6adc28"]]);
export {
  Ae as default
};
