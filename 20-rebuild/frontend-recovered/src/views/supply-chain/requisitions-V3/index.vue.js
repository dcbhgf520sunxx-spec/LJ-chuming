import { useStore as H } from "vuex";
import { ref as S } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as b } from "vue";
import { ElMessageBox as q } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElPopover as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as J, uP as g, jP as p, x as W, w0 as C, w1 as Y, o as Z, iX as ee, c as D, G as R, vd as f, oz as te, an as ae, P as oe, b as ie, lP as se, w4 as ne, i as le } from "../../../shared/runtime.js";
import re from "./module/header.vue.js";
import pe from "./module/form.vue.js";
import ce from "./module/detail.vue.js";
import me from "./module/track-drawer.vue.js";
import "../../../modules/use-approval-cfg-0a67817c.js";
import "../components/audit-records.vue.js";
import "../requisitions-V2/module/application/components/temporary-storage.vue.js";
import "./module/application/steel/index.vue.js";
import "./module/application/components/common-wrapper.vue.js";
import "./module/application/components/common-footer.vue.js";
import "./module/application/components/confirm-dialog.vue.js";
import "./module/application/steel/module/steel-plate-table.vue.js";
import "./module/application/steel/module/section-steel-table.vue.js";
import "./module/application/steel/module/steel-coil-table.vue.js";
import "./module/application/steel/module/other-steel-materials-table.vue.js";
import "./module/application/components/inventory-drawer.vue.js";
import "./module/application/components/capsule-label/index.vue.js";
import "./module/application/auxiliary-material/index.vue.js";
import "../../../modules/aux-material-a427f83d.js";
import "./module/application/auxiliary-material/module/aux-mat-table.vue.js";
import "./module/application/manufactured/index.vue.js";
import "./module/application/manufactured/module/enclosure-table.vue.js";
import "./module/application/manufactured/module/structure-table.vue.js";
import "./module/application/other/index.vue.js";
import "../../../modules/other-e93f8d3e.js";
import "./module/application/gas/index.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
const de = { class: "app-container" }, ue = { key: 0 }, fe = { key: 0 }, he = { key: 1 }, _e = { key: 1 }, ye = { key: 1 }, be = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, ge = { __name: "index", setup(Te) {
  const M = H(), x = { add: true, edit: false, del: false, download: false }, w = S(), A = S([["project", ["parse-project", { onlyShortName: true }]], ["dataStatus", ["parse-enum", g, { f: "L" }]], ["dataStatusTag", ["parse-enum", g, { f: "T" }], { source: "dataStatus" }], ["materialTypeTag", ["parse-enum", p, { f: "T" }], { source: "materialType" }], ["materialType", ["parse-enum", p, { f: "L" }]], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: U, crud: d, columns: c } = W({ title: "材料申购", permission: { ...C }, invisibleColumns: [], crudApi: { ...Y }, optShow: { ...x } }, w), { maxHeight: O } = Z({ paginate: true }), N = S(false), j = S({});
  U.HOOK.handleRefresh = (i, { data: m }) => {
    m.content.forEach((e) => {
      var h;
      e.materialType & p.STEEL.V && (e.materialType = p.STEEL.V), e.materialType & p.MANUFACTURED.V && (e.basicClass = e.materialType, e.materialType = p.MANUFACTURED.V), e.inboundMete = e.inboundMete || 0, e.totalMete = e.totalMete || 0, e.projectNames = [], (h = e.projectInfos) == null || h.forEach((T) => {
        e.projectNames.push(T.serialNumber + " " + T.shortName);
      }), e.projectNames = e.projectNames.join(","), e.inboundRate = e.inboundMete ? ee(e.inboundMete / e.totalMete * 100, 2) : 0, e.materialType === p.STEEL.V && (e.inboundMete = D(e.inboundMete, "g", "kg"), e.totalMete = D(e.totalMete, "g", "kg"));
    });
  };
  async function P(i) {
    i.loading = true;
    try {
      ie(i.wmsApproveRecordFlowDTO) && (i.wmsApproveRecordFlowDTO = await se(i.approveRecordIdNow));
    } catch (m) {
      console.log(m, "获取失败");
    } finally {
      i.loading = false;
    }
  }
  function F(i) {
    if (i.purchaseCreationState) {
      const m = [{ id: i.id, purchaseCreationState: i.purchaseCreationState }];
      q.confirm("是否要修改采购状态?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", closeOnClickModal: false }).then(async () => {
        await ne(m), z({ type: "success", message: "修改成功" });
      }).finally(() => {
        d.refresh();
      });
    }
  }
  function L(i) {
    if (le(d.selections)) {
      if (d.selections[0].materialType === p.MANUFACTURED.V) {
        if (!(i.basicClass & p.MANUFACTURED.V)) return false;
      } else if (i.basicClass & p.MANUFACTURED.V) return false;
    }
    return true;
  }
  return $(() => M.state.approval_list.isRefresh, (i) => {
    i && d.toQuery();
  }, { deep: true }), (i, m) => {
    const e = K, h = G, T = V("common-select"), B = Q, I = V("common-table"), k = X;
    return o(), u("div", de, [s(t(re)), v((o(), n(I, { ref_key: "tableRef", ref: w, data: t(d).data, "data-format": A.value, "max-height": t(O), class: "hidden-table-check-all", style: { width: "100%" }, onSelectionChange: t(d).selectionChangeHandler }, { default: l(() => [s(e, { selectable: L, align: "center", fixed: "left", type: "selection", width: "55" }), s(e, { align: "center", label: "序号", type: "index", width: "60" }), t(c).visible("createTime") ? (o(), n(e, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : r("", true), t(c).visible("departmentName") ? (o(), n(e, { key: "departmentName", align: "center", label: "部门", prop: "departmentName", "show-overflow-tooltip": "", width: "120" })) : r("", true), t(c).visible("applicantName") ? (o(), n(e, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", "show-overflow-tooltip": "", width: "120" })) : r("", true), t(c).visible("projectNames") ? (o(), n(e, { key: "projectNames", align: "left", label: "项目", "min-width": "120", prop: "projectNames", "show-overflow-tooltip": "" }, { default: l(({ row: a }) => [y(b(a.projectNames || "-"), 1)]), _: 1 })) : r("", true), t(c).visible("branchCompany.name") ? (o(), n(e, { key: "branchCompany.name", align: "left", label: "申购单位", "min-width": "120", prop: "branchCompany.name", "show-overflow-tooltip": "" }, { default: l(({ row: { sourceRow: a } }) => {
      var _;
      return [y(b(((_ = a.branchCompany) == null ? void 0 : _.name) || "-"), 1)];
    }), _: 1 })) : r("", true), t(c).visible("serialNumber") ? (o(), n(e, { key: "serialNumber", align: "left", label: "申购编号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), t(c).visible("materialType") ? (o(), n(e, { key: "materialType", align: "center", label: "材料分类", prop: "materialType", "show-overflow-tooltip": "", width: "100" }, { default: l(({ row: a }) => [s(h, { type: a.materialTypeTag, effect: "plain", size: "large" }, { default: l(() => [y(b(a.materialType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), s(e, { align: "center", label: "采购状态", prop: "purchaseCreationState", width: "120" }, { default: l(({ row: { sourceRow: a } }) => {
      var _;
      return [!t(R)(t(C).procurementStatus) || a.purchaseCreationState === t(f).COMPLETED.V || a.purchaseCreationState === t(f).NOT_STARTED.V ? (o(), u("div", ue, [a.purchaseCreationState ? (o(), u("div", fe, [a.dataStatus !== t(g).PASSED.L ? (o(), n(h, { key: 0, type: (_ = t(f).V[a.purchaseCreationState]) == null ? void 0 : _.T, effect: "plain" }, { default: l(() => [y(b(t(f).VL[a.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : r("", true)])) : (o(), u("span", he, "-"))])) : (o(), u("div", _e, [a.purchaseCreationState ? (o(), n(T, { key: 0, modelValue: a.purchaseCreationState, "onUpdate:modelValue": (E) => a.purchaseCreationState = E, disabled: a.dataStatus === t(g).INVALID.V || a.dataStatus === t(g).VOIDED.V, disabledVal: [t(f).NOT_STARTED.V], options: t(f).ENUM, unshowOptions: [t(f).NOT_STARTED.K], placeholder: "请选择采购类型", type: "enum", onChange: (E) => F(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledVal", "options", "unshowOptions", "onChange"])) : (o(), u("span", ye, "-"))]))];
    }), _: 1 }), t(c).visible("dataStatus") ? (o(), n(e, { key: "dataStatus", align: "center", label: "审批状态", "show-overflow-tooltip": "", width: "90" }, { default: l(({ row: a }) => [s(B, { width: 400, placement: "top", trigger: "click", onShow: (_) => P(a) }, { reference: l(() => [s(h, { type: a.dataStatusTag, effect: "plain", size: "default", style: { cursor: "pointer" } }, { default: l(() => [y(b(a.dataStatus), 1)]), _: 2 }, 1032, ["type"])]), default: l(() => [v((o(), u("div", be, [s(te, { data: a.wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[k, a.loading]])]), _: 2 }, 1032, ["onShow"])]), _: 1 })) : r("", true), t(R)([...t(C).detail]) ? (o(), n(e, { key: 8, align: "center", fixed: "right", label: "操作", width: "70" }, { default: l(({ row: { sourceRow: a } }) => [s(ae, { data: { id: a.id }, permission: t(C), "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data", "permission"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[k, t(d).loading]]), s(t(oe)), s(t(pe)), s(ce, { "show-buttom": "" }), s(t(me), { visible: N.value, "onUpdate:visible": m[0] || (m[0] = (a) => N.value = a), info: j.value }, null, 8, ["visible", "info"])]);
  };
} }, We = J(ge, [["__scopeId", "data-v-a5672fd8"]]);
export {
  We as default
};
