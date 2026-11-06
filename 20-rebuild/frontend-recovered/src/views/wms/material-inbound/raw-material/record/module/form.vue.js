import { _ as O, ao as I, sQ as b, cV as T, am as s, cO as y, jl as C, jZ as S, i as u, V as w, sK as j, iX as A } from "../../../../../../shared/runtime.js";
import l from "../../application/steel/index.vue.js";
import L from "../../application/auxiliary-material/index.vue.js";
import V from "../../application/other/index.vue.js";
import N from "../../application/gas/index.vue.js";
import P from "../../../manufactured/index.vue.js";
import { computed as U } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as d } from "vue";
import { createBlock as h } from "vue";
import { withCtx as M } from "vue";
import { resolveDynamicComponent as k } from "vue";
import { unref as o } from "vue";
import "../../application/components/common-wrapper.vue.js";
import "../../application/components/common-header.vue.js";
import "../../application/components/common-footer.vue.js";
import "../../application/components/confirm-dialog.vue.js";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
import "../../application/steel/module/steel-plate-table.vue.js";
import "../../../../../../modules/use-over-receive-ba08adae.js";
import "../../application/components/inbound-quantity-column.vue.js";
import "../../application/steel/module/section-steel-table.vue.js";
import "../../application/steel/module/steel-coil-table.vue.js";
import "../../application/auxiliary-material/module/aux-mat-table.vue.js";
import "../../application/gas/module/gas-table.vue.js";
import "../../../manufactured/module/struc-manuf-table.vue.js";
import "../../../manufactured/module/encl-manuf-table.vue.js";
const x = { __name: "form", setup(B) {
  const { CRUD: n, crud: t, form: p } = I(), { baseUnit: f } = b(), _ = U(() => {
    switch (p.basicClass) {
      case s.STEEL_PLATE.V:
      case s.SECTION_STEEL.V:
      case s.STEEL_COIL.V:
        return l;
      case s.MATERIAL.V:
        return L;
      case s.GAS.V:
        return N;
      case s.STRUC_MANUFACTURED.V:
      case s.ENCL_MANUFACTURED.V:
        return P;
      case s.OTHER.V:
        return V;
      default:
        return p.basicClass & T ? l : void 0;
    }
  });
  n.HOOK.beforeEditDetailLoaded = async (g, r) => {
    await y(r.list), r.list = await C(r.list, { toSmallest: false, toNum: true }), r.list.forEach((e) => {
      var a, i, c, m;
      e.warehouseName = ((a = e.workshop) == null ? void 0 : a.name) || e.warehouseName, e.workshopId = ((i = e.workshop) == null ? void 0 : i.id) || e.workshopId, e.warehouseId = ((c = e.warehouse) == null ? void 0 : c.id) || e.warehouseId, e.projectId = ((m = e.project) == null ? void 0 : m.id) || e.projectId;
    }), r.logistics = r.logisticsOrder, r.supplyType !== S.PARTY_A.V && u(r.purchaseOrder.details) && (r.originList = w(r.list), await j(r.originList), r.list = [], r.editObj = {}, r.originList.forEach((e) => {
      var a, i;
      e.basicClass & (s.STEEL_PLATE.V | s.SECTION_STEEL.V) && (e.theoryTotalWeight = A(e.theoryWeight * e.quantity, f.value[e.basicClass].weight.precision)), r.editObj[e.mergeId] ? (r.editObj[e.mergeId].applyPurchaseObj[e.applyPurchaseId] ? r.editObj[e.mergeId].applyPurchaseObj[e.applyPurchaseId].push({ ...e }) : r.editObj[e.mergeId].applyPurchaseObj[e.applyPurchaseId] = [{ ...e }], r.editObj[e.mergeId].quantity += e.quantity, r.editObj[e.mergeId].mete += e.mete) : (r.editObj[e.mergeId] = { ...e, applyPurchaseObj: { [e.applyPurchaseId]: [{ ...e }] }, isSelected: true }, e.basicClass & s.SECTION_STEEL.V && u(r.purchaseOrder) && (r.editObj[e.mergeId].length = ((i = (a = r.purchaseOrder) == null ? void 0 : a.details.find((c) => c.id === e.mergeId)) == null ? void 0 : i.length) || r.editObj[e.mergeId].length));
    }));
  };
  function E() {
    t.cancelCU(), t.refresh();
  }
  return (g, r) => {
    const e = R("common-drawer");
    return d(), h(e, { ref: "drawerRef", "before-close": o(t).cancelCU, "content-loading": o(t).editDetailLoading, "show-close": true, title: o(t).status.title, visible: o(t).status.cu > o(n).STATUS.NORMAL, "custom-class": "raw-mat-inbound-application-record-form", size: "90%" }, { content: M(() => [(d(), h(k(_.value), { detail: o(p), edit: "", onSuccess: E }, null, 40, ["detail"]))]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, pe = O(x, [["__scopeId", "data-v-d74334fd"]]);
export {
  pe as default
};
