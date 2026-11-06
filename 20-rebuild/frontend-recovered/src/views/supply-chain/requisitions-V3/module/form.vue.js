import { _ as Q, jP as i, wb as m, ao as W, i as N, wc as L, cO as j, jl as w, c as T, wd as l, iX as y, b as J, we as K, G as X, vf as Y, t0 as E, wf as $ } from "../../../../shared/runtime.js";
import Z from "./application/steel/index.vue.js";
import ee from "./application/auxiliary-material/index.vue.js";
import te from "./application/manufactured/index.vue.js";
import ae from "./application/other/index.vue.js";
import ie from "./application/gas/index.vue.js";
import { useStore as oe } from "vuex";
import { computed as c } from "vue";
import { ref as P } from "vue";
import { cloneDeep as se } from "lodash";
import { watch as ne } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as I } from "vue";
import { createSlots as re } from "vue";
import { withCtx as C } from "vue";
import { createElementVNode as le } from "vue";
import { createVNode as F } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as g } from "vue";
import { resolveDynamicComponent as ue } from "vue";
import { createTextVNode as ce } from "vue";
import { ElMessage as v } from "element-plus";
import "./application/components/common-wrapper.vue.js";
import "./application/components/common-footer.vue.js";
import "./application/components/confirm-dialog.vue.js";
import "./application/steel/module/steel-plate-table.vue.js";
import "./application/steel/module/section-steel-table.vue.js";
import "./application/steel/module/steel-coil-table.vue.js";
import "./application/steel/module/other-steel-materials-table.vue.js";
import "./application/components/inventory-drawer.vue.js";
import "./application/components/capsule-label/index.vue.js";
import "../../../../modules/aux-material-a427f83d.js";
import "./application/auxiliary-material/module/aux-mat-table.vue.js";
import "./application/manufactured/module/enclosure-table.vue.js";
import "./application/manufactured/module/structure-table.vue.js";
import "../../../../modules/other-e93f8d3e.js";
const me = { class: "requisitions-application-select" }, pe = { __name: "form", props: { isTsData: { type: Boolean, default: false } }, emits: ["saveSuccess", "detailSuccess"], setup(O, { emit: k }) {
  const u = oe(), R = k, b = O, H = { materialType: i.STEEL.V, branchCompanyId: void 0, finishedProductType: m.STRUC_MANUFACTURED.V, arrivalTime: "", attachments: void 0, serialNumber: "", steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [], remark: "", level: void 0, list: [] }, z = c(() => {
    let a = [];
    return h.value && (o.materialType & i.MANUFACTURED.V ? a = [i.STEEL.V, i.MATERIAL.V, i.GAS.V, i.OTHER.V] : a = [i.MANUFACTURED.V]), a;
  }), { CRUD: V, crud: n, form: o } = W(H), D = c(() => n.status.cu > V.STATUS.NORMAL), h = c(() => n.status.edit > 0), S = c(() => !!(o.materialType & i.MANUFACTURED.V)), p = P(), B = c(() => b.isTsData ? true : !h.value), A = P(), x = c(() => {
    switch (o.materialType) {
      case i.STEEL.V:
        return Z;
      case i.MATERIAL.V:
        return ee;
      case i.MANUFACTURED.V:
        return te;
      case i.OTHER.V:
        return ae;
      case i.GAS.V:
        return ie;
      default:
        return;
    }
  });
  V.HOOK.beforeEditDetailLoaded = async (a, t) => {
    var d;
    N(t.tsData) && (t.detailList = JSON.parse(t.tsData)), S.value ? (t.materialType & i.MANUFACTURED.V && (t.materialType = i.MANUFACTURED.V), (d = p.value) == null || d.refresh(), t.list = t.detailList.map((e) => (e.totalLength = T(y(e.totalLength, l.LENGTH_DP), l.LENGTH, "m"), e.totalWeight = T(y(e.totalWeight, l.WEIGHT_DP), l.WEIGHT, "kg"), e.weight = T(y(e.weight, l.WEIGHT_DP), l.WEIGHT, "kg"), e.totalArea = T(y(e.totalArea, l.AREA_DP), l.AREA, "m²"), e)), A.value = se(t), A.value.list.forEach((e) => {
      e.name = e.manufacturedName, e.serialNumber = e.manufacturedSn, o.finishedProductType === m.STRUC_MANUFACTURED.V && (e.productId = e.artifactEnclosureId, e.netWeight = e.weight), o.finishedProductType === m.ENCL_MANUFACTURED.V && (e.id = e.artifactEnclosureId, e.category = e.manufacturedType);
    })) : (t.originInventoryInfo || (t.originInventoryInfo = {}), t.materialType & i.STEEL.V && (t.materialType = i.STEEL.V), t.list = t.detailList.map((e) => {
      var f, r;
      return e.materialInventoryId ? (e.requisitionMode = L.USE_INVENTORY.V, t.originInventoryInfo[e.materialInventoryId] ? (t.originInventoryInfo[e.materialInventoryId].frozenQuantity -= e.quantity, t.originInventoryInfo[e.materialInventoryId].frozenQuantity < 0 && (t.originInventoryInfo[e.materialInventoryId].frozenQuantity = 0)) : t.originInventoryInfo[e.materialInventoryId] = { quantity: (f = e.materialFreezeNum) == null ? void 0 : f.quantity, frozenQuantity: ((r = e.materialFreezeNum) == null ? void 0 : r.frozenQuantity) - e.quantity }) : e.requisitionMode = L.PURCHASE.V, e;
    }), await j(t.list), t.list = await w(t.list, { toSmallest: false, toNum: true }));
  }, ne(() => o.materialType, (a, t) => {
    a && t && a !== t && (o.list = []), a === i.MANUFACTURED.V && J(o.finishedProductType) && (o.finishedProductType = m.STRUC_MANUFACTURED.V), a !== i.MANUFACTURED.V && (o.finishedProductType = void 0);
  });
  function M() {
    u.dispatch("approval_list/fetchApprovalNum"), u.dispatch("approval_list/fetchApprovalNum", E.REQUISITIONS_V2.V), u.dispatch("approval_list/fetchSubNum", E.REQUISITIONS_V2.V), u.dispatch("approval_list/fetchRejNum", E.REQUISITIONS_V2.V), n.cancelCU(), R("detailSuccess"), n.refresh();
  }
  function G(a) {
    o.branchCompany = a, o.level = a == null ? void 0 : a.level;
  }
  async function q() {
    p.value.TSValidateTable();
    const a = JSON.parse(JSON.stringify(p.value.form));
    a.materialType & i.STEEL.V && (a.list = [...a.steelPlateList, ...a.sectionSteelList, ...a.steelCoilList, ...a.otherSteelMaterialList]), N(a.list) ? (a.list = await w(a.list, { toSmallest: true, toNum: true }), N(a.attachments) && (a.attachmentIds = a.attachments.map((t) => t.id)), a.clickTime = u.state.config.getTreeClickTime, a.tsData = JSON.stringify(a.list), await $(a).then(async (t) => {
      t === true && (v.success("暂存成功"), R("saveSuccess"), M(), await u.dispatch("approval_list/fetchTSNum", E.REQUISITIONS_V2.V));
    })) : v.error("请填写数据");
  }
  return (a, t) => {
    const d = U("common-button"), e = U("common-radio-button"), f = U("common-drawer");
    return _(), I(f, { ref: "drawerRef", "before-close": s(n).cancelCU, "content-loading": s(n).editDetailLoading, "show-close": true, title: s(n).status.title, visible: D.value, "custom-class": "requisitions-application-record-form", size: "100%" }, re({ titleRight: C(() => [s(X)(s(Y).scmTemporaryStoragePM.add) && B.value && !S.value ? (_(), I(d, { key: 0, class: "filter-item", size: "default", type: "warning", onClick: q }, { default: C(() => t[3] || (t[3] = [ce(" 暂存 ")])), _: 1, __: [3] })) : g("", true)]), _: 2 }, [D.value ? { name: "content", fn: C(() => [le("div", me, [F(e, { modelValue: s(o).materialType, "onUpdate:modelValue": t[0] || (t[0] = (r) => s(o).materialType = r), disabledVal: z.value, options: s(i).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"]), S.value ? (_(), I(e, { key: 0, modelValue: s(o).finishedProductType, "onUpdate:modelValue": t[1] || (t[1] = (r) => s(o).finishedProductType = r), options: s(m).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])) : g("", true), F(K, { modelValue: s(o).branchCompanyId, "onUpdate:modelValue": t[2] || (t[2] = (r) => s(o).branchCompanyId = r), disabled: !!s(o).boolUsed, class: "input-underline", clearable: "", placeholder: "请选择申购单位", style: { width: "240px" }, onCurrentChange: G }, null, 8, ["modelValue", "disabled"])]), s(n).status.cu > s(V).STATUS.NORMAL ? (_(), I(ue(x.value), { key: 0, ref_key: "applicationRef", ref: p, detail: s(o), formHistory: A.value, isEdit: h.value, isTsData: b.isTsData, onSuccess: M }, null, 40, ["detail", "formHistory", "isEdit", "isTsData"])) : g("", true)]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "title", "visible"]);
  };
} }, Pe = Q(pe, [["__scopeId", "data-v-c70fa32e"]]);
export {
  Pe as default
};
