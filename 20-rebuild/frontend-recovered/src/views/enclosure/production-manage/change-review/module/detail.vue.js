import { ref as f } from "vue";
import { watch as H } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as K } from "vue";
import { createBlock as w } from "vue";
import { withCtx as n } from "vue";
import { createVNode as s } from "vue";
import { unref as l } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as g } from "vue";
import { createElementBlock as O } from "vue";
import { Fragment as U } from "vue";
import { createCommentVNode as P } from "vue";
import { withDirectives as Q } from "vue";
import { createElementVNode as D } from "vue";
import { normalizeStyle as B } from "vue";
import { isRef as $ } from "vue";
import { ElMessage as J } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElDescriptionsItem as Y } from "element-plus";
import { ElDescriptions as Z } from "element-plus";
import { ElTableColumn as v } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as ae, u as te, i as W, o as re, mC as b, G as ne, z as ie, p as se } from "../../../../../shared/runtime.js";
import { a as le } from "../../../../../modules/enclosure-change-log-d4bf065e.js";
const ce = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, uploadList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(c, { emit: C }) {
  const R = C, o = c, { visible: p, handleClose: A } = te({ emit: R, props: o }), h = f([]), k = f(), E = f(false), I = f(), y = f(false), V = f([]);
  H(p, async (u) => {
    if (u) {
      h.value = [], V.value = [];
      const t = ["updateArtifactList", "delArtifactList"];
      await q();
      for (let r = 0; r < t.length; r++) W(o.currentRow[t[r]]) && o.currentRow[t[r]].forEach((e) => {
        if (h.value.findIndex((i) => i.rowKey === e.serialNumber) < 0) {
          const i = { dataType: 1, serialNumber: e.serialNumber, name: e.name, rowKey: e.serialNumber, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, children: [{ dataType: 2, modifyType: t[r] === "updateArtifactList" ? 1 : 2, sortNumber: e.sortNumber, rowKey: e.serialNumber + "_" + e.sortNumber, serialNumber: e.serialNumber + "(" + e.sortNumber + ")", name: e.name, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, newVal: t[r] === "updateArtifactList" ? { serialNumber: e.changeSerialNumber, name: e.changeName, grossWeight: e.changeGrossWeight, length: e.changeLength, material: e.changeMaterial, netWeight: e.changeNetWeight, specification: e.changeSpecification, surfaceArea: e.changeSurfaceArea } : {} }] };
          V.value.push(i.rowKey), h.value.push({ ...i });
        } else {
          const i = h.value.find((m) => m.rowKey === e.serialNumber) || {};
          if (W(i) && i.children.findIndex((m) => m.sortNumber === e.sortNumber) < 0) {
            const m = { dataType: 2, modifyType: t[r] === "updateArtifactList" ? 1 : 2, sortNumber: e.sortNumber, serialNumber: e.serialNumber + "(" + e.sortNumber + ")", rowKey: e.serialNumber + "_" + e.sortNumber, name: e.name, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, newVal: t[r] === "updateArtifactList" ? { serialNumber: e.changeSerialNumber, name: e.changeName, grossWeight: e.changeGrossWeight, length: e.changeLength, material: e.changeMaterial, netWeight: e.changeNetWeight, specification: e.changeSpecification, surfaceArea: e.changeSurfaceArea } : {} };
            i.children.push({ ...m });
          }
        }
      });
      W(o.currentRow.artifactBasicUpdateDTOList) && o.currentRow.artifactBasicUpdateDTOList.map((r) => {
        h.value.push({ ...r, surfaceArea: r.surfaceArea / 1e6, rowKey: r.serialNumber, modifyType: 1, dataType: 1, children: [], newVal: { quantity: r.changeQuantity || r.quantity, serialNumber: r.serialNumber, name: r.name, grossWeight: r.changeGrossWeight, length: r.changeLength, material: r.material, netWeight: r.changeNetWeight, specification: r.specification, surfaceArea: r.changeSurfaceArea / 1e6 } });
      });
    }
  }, { immediate: true, deep: true });
  const { maxHeight: j } = re({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, k), M = [{ label: "名称", beforeKey: "name", afterKey: "changeName" }, { label: "编号", beforeKey: "serialNumber", afterKey: "changeSerialNumber" }, { label: "规格", beforeKey: "specification", afterKey: "changeSpecification" }, { label: "展开宽度(mm)", beforeKey: "unfoldedWidth", afterKey: "changeUnfoldedWidth" }, { label: "有效宽度(mm)", beforeKey: "width", afterKey: "changeWidth" }, { label: "厚度(mm)", beforeKey: "thickness", afterKey: "changeThickness" }, { label: "单长(mm)", beforeKey: "length", afterKey: "changeLength" }, { label: "数量(张)", beforeKey: "quantity", afterKey: "changeQuantity" }, { label: "重量(kg)", beforeKey: "weight", afterKey: "changeWeight" }, { label: "备注", beforeKey: "remark", afterKey: "changeRemark" }], L = f([]);
  async function q() {
    if (Object.keys(o.currentRow.changeRecordDetail).length) {
      const { changeRecordDetail: u } = o.currentRow;
      L.value = M.map((t) => {
        const r = u[t.beforeKey] ?? "", e = u[t.afterKey] ?? "";
        return { 项目: t.label, before: r, after: e };
      });
    }
  }
  async function S(u) {
    try {
      y.value = true;
      const t = { checkStatus: u, id: o.currentRow.id };
      await le(t), J({ type: "success", message: "操作成功" }), R("success"), A();
    } catch (t) {
      console.log(t);
    } finally {
      y.value = false;
    }
  }
  return (u, t) => {
    const r = X, e = _("common-button"), i = Y, m = Z, N = v, z = _("common-table"), F = _("common-drawer"), G = ee;
    return K(), w(F, { ref_key: "drawerRef", ref: k, modelValue: l(p), "onUpdate:modelValue": t[2] || (t[2] = (a) => $(p) ? p.value = a : null), "before-close": l(A), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "40%", title: "清单明细" }, { titleAfter: n(() => {
      var a, T;
      return [s(r, { type: (T = l(b).V[(a = c.currentRow) == null ? void 0 : a.checkStatus]) == null ? void 0 : T.T }, { default: n(() => {
        var x;
        return [d(g(l(b).VL[(x = c.currentRow) == null ? void 0 : x.checkStatus]), 1)];
      }), _: 1 }, 8, ["type"])];
    }), titleRight: n(() => [c.currentRow.checkStatus === l(b).AUDITING.V && l(ne)(c.permission.cancel) ? (K(), O(U, { key: 0 }, [s(e, { loading: y.value, size: "default", type: "danger", onClick: t[0] || (t[0] = (a) => S(l(b).REJECT.V)) }, { default: n(() => t[3] || (t[3] = [d("驳回 ")])), _: 1, __: [3] }, 8, ["loading"]), s(e, { loading: y.value, size: "default", type: "success", onClick: t[1] || (t[1] = (a) => S(l(b).PASS.V)) }, { default: n(() => t[4] || (t[4] = [d("通过 ")])), _: 1, __: [4] }, 8, ["loading"])], 64)) : P("", true)]), content: n(() => [s(m, { column: 1, border: "", class: "margin-top", "label-width": "140" }, { default: n(() => [s(i, { label: "项目", "label-class-name": "contractLabel" }, { default: n(() => [d(g(l(ie)(c.currentRow.project)), 1)]), _: 1 }), s(i, { label: "单体/区域", "label-class-name": "contractLabel" }, { default: n(() => {
      var a;
      return [d(g((a = c.currentRow.monomer) == null ? void 0 : a.name), 1)];
    }), _: 1 }), s(i, { label: "创建人", "label-class-name": "contractLabel" }, { default: n(() => [d(g(c.currentRow.user.name), 1)]), _: 1 }), s(i, { label: "日期", "label-class-name": "contractLabel" }, { default: n(() => [d(g(l(se)(c.currentRow.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 })]), _: 1 }), Q((K(), w(z, { ref_key: "serialNumberRef", ref: I, data: L.value, "max-height": l(j) - 280, "return-source-data": "", style: { "margin-top": "20px" } }, { default: n(() => [s(N, { align: "left", "header-align": "center", label: "项目", prop: "项目" }), s(N, { align: "left", "header-align": "center", label: "变成前", prop: "before" }, { default: n(({ row: a }) => [D("span", { style: B({ color: (a == null ? void 0 : a.before) !== (a == null ? void 0 : a.after) ? "red" : "" }) }, g(a == null ? void 0 : a.before), 5)]), _: 1 }), s(N, { align: "left", "header-align": "center", label: "变更后", prop: "after" }, { default: n(({ row: a }) => [D("span", { style: B({ color: (a == null ? void 0 : a.after) !== (a == null ? void 0 : a.before) ? "green" : "" }) }, g(a == null ? void 0 : a.after), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[G, E.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, fe = ae(ce, [["__scopeId", "data-v-5aa9b4dc"]]);
export {
  fe as default
};
