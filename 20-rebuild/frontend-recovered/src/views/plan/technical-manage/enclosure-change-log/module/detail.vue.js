import { ref as f } from "vue";
import { watch as U } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as K } from "vue";
import { createBlock as W } from "vue";
import { withCtx as i } from "vue";
import { createVNode as c } from "vue";
import { unref as s } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as z } from "vue";
import { withDirectives as F } from "vue";
import { createElementVNode as w } from "vue";
import { normalizeStyle as D } from "vue";
import { isRef as Q } from "vue";
import { ElMessage as P } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { _ as v, u as ee, i as A, o as ae, mC as p, G as te, z as re, p as ne } from "../../../../../shared/runtime.js";
import { a as ie } from "../../../../../modules/enclosure-change-log-d4bf065e.js";
const se = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, uploadList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(l, { emit: C }) {
  const R = C, o = l, { visible: b, handleClose: k } = ee({ emit: R, props: o }), h = f([]), V = f(), B = f(false), E = f(), y = f(false), L = f([]);
  U(b, async (u) => {
    if (u) {
      h.value = [], L.value = [];
      const r = ["updateArtifactList", "delArtifactList"];
      await M();
      for (let t = 0; t < r.length; t++) A(o.currentRow[r[t]]) && o.currentRow[r[t]].forEach((e) => {
        if (h.value.findIndex((n) => n.rowKey === e.serialNumber) < 0) {
          const n = { dataType: 1, serialNumber: e.serialNumber, name: e.name, rowKey: e.serialNumber, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, children: [{ dataType: 2, modifyType: r[t] === "updateArtifactList" ? 1 : 2, sortNumber: e.sortNumber, rowKey: e.serialNumber + "_" + e.sortNumber, serialNumber: e.serialNumber + "(" + e.sortNumber + ")", name: e.name, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, newVal: r[t] === "updateArtifactList" ? { serialNumber: e.changeSerialNumber, name: e.changeName, grossWeight: e.changeGrossWeight, length: e.changeLength, material: e.changeMaterial, netWeight: e.changeNetWeight, specification: e.changeSpecification, surfaceArea: e.changeSurfaceArea } : {} }] };
          L.value.push(n.rowKey), h.value.push({ ...n });
        } else {
          const n = h.value.find((m) => m.rowKey === e.serialNumber) || {};
          if (A(n) && n.children.findIndex((m) => m.sortNumber === e.sortNumber) < 0) {
            const m = { dataType: 2, modifyType: r[t] === "updateArtifactList" ? 1 : 2, sortNumber: e.sortNumber, serialNumber: e.serialNumber + "(" + e.sortNumber + ")", rowKey: e.serialNumber + "_" + e.sortNumber, name: e.name, grossWeight: e.grossWeight, length: e.length, material: e.material, netWeight: e.netWeight, specification: e.specification, surfaceArea: e.surfaceArea, newVal: r[t] === "updateArtifactList" ? { serialNumber: e.changeSerialNumber, name: e.changeName, grossWeight: e.changeGrossWeight, length: e.changeLength, material: e.changeMaterial, netWeight: e.changeNetWeight, specification: e.changeSpecification, surfaceArea: e.changeSurfaceArea } : {} };
            n.children.push({ ...m });
          }
        }
      });
      A(o.currentRow.artifactBasicUpdateDTOList) && o.currentRow.artifactBasicUpdateDTOList.map((t) => {
        h.value.push({ ...t, surfaceArea: t.surfaceArea / 1e6, rowKey: t.serialNumber, modifyType: 1, dataType: 1, children: [], newVal: { quantity: t.changeQuantity || t.quantity, serialNumber: t.serialNumber, name: t.name, grossWeight: t.changeGrossWeight, length: t.changeLength, material: t.material, netWeight: t.changeNetWeight, specification: t.specification, surfaceArea: t.changeSurfaceArea / 1e6 } });
      });
    }
  }, { immediate: true, deep: true });
  const { maxHeight: I } = ae({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, V), j = [{ label: "名称", beforeKey: "name", afterKey: "changeName" }, { label: "编号", beforeKey: "serialNumber", afterKey: "changeSerialNumber" }, { label: "规格", beforeKey: "specification", afterKey: "changeSpecification" }, { label: "展开宽度(mm)", beforeKey: "unfoldedWidth", afterKey: "changeUnfoldedWidth" }, { label: "有效宽度(mm)", beforeKey: "width", afterKey: "changeWidth" }, { label: "厚度(mm)", beforeKey: "thickness", afterKey: "changeThickness" }, { label: "单长(mm)", beforeKey: "length", afterKey: "changeLength" }, { label: "数量(张)", beforeKey: "quantity", afterKey: "changeQuantity" }, { label: "重量(kg)", beforeKey: "weight", afterKey: "changeWeight" }, { label: "备注", beforeKey: "remark", afterKey: "changeRemark" }], x = f([]);
  async function M() {
    if (Object.keys(o.currentRow.changeRecordDetail).length) {
      const { changeRecordDetail: u } = o.currentRow;
      x.value = j.map((r) => {
        const t = u[r.beforeKey] ?? "", e = u[r.afterKey] ?? "";
        return { 项目: r.label, before: t, after: e };
      });
    }
  }
  async function q(u) {
    try {
      y.value = true;
      const r = { checkStatus: u, id: o.currentRow.id };
      await ie(r), P({ type: "success", message: "操作成功" }), R("success"), k();
    } catch (r) {
      console.log(r);
    } finally {
      y.value = false;
    }
  }
  return (u, r) => {
    const t = $, e = _("common-button"), n = J, m = X, N = Y, G = _("common-table"), H = _("common-drawer"), O = Z;
    return K(), W(H, { ref_key: "drawerRef", ref: V, modelValue: s(b), "onUpdate:modelValue": r[1] || (r[1] = (a) => Q(b) ? b.value = a : null), "before-close": s(k), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "40%", title: "清单明细" }, { titleAfter: i(() => {
      var a, T;
      return [c(t, { type: (T = s(p).V[(a = l.currentRow) == null ? void 0 : a.checkStatus]) == null ? void 0 : T.T }, { default: i(() => {
        var S;
        return [d(g(s(p).VL[(S = l.currentRow) == null ? void 0 : S.checkStatus]), 1)];
      }), _: 1 }, 8, ["type"])];
    }), titleRight: i(() => [l.currentRow.checkStatus === s(p).AUDITING.V && s(te)(l.permission.cancel) ? (K(), W(e, { key: 0, loading: y.value, size: "default", type: "warning", onClick: r[0] || (r[0] = (a) => q(s(p).CANCEL.V)) }, { default: i(() => r[2] || (r[2] = [d(" 撤销 ")])), _: 1, __: [2] }, 8, ["loading"])) : z("", true)]), content: i(() => [c(m, { column: 1, border: "", class: "margin-top", "label-width": "140" }, { default: i(() => [c(n, { label: "项目", "label-class-name": "contractLabel" }, { default: i(() => [d(g(s(re)(l.currentRow.project)), 1)]), _: 1 }), c(n, { label: "单体/区域", "label-class-name": "contractLabel" }, { default: i(() => {
      var a;
      return [d(g((a = l.currentRow.monomer) == null ? void 0 : a.name), 1)];
    }), _: 1 }), c(n, { label: "创建人", "label-class-name": "contractLabel" }, { default: i(() => [d(g(l.currentRow.user.name), 1)]), _: 1 }), c(n, { label: "日期", "label-class-name": "contractLabel" }, { default: i(() => [d(g(s(ne)(l.currentRow.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 })]), _: 1 }), F((K(), W(G, { ref_key: "serialNumberRef", ref: E, data: x.value, "max-height": s(I) - 280, "return-source-data": "", style: { "margin-top": "20px" } }, { default: i(() => [c(N, { align: "left", "header-align": "center", label: "项目", prop: "项目" }), c(N, { align: "left", "header-align": "center", label: "变成前", prop: "before" }, { default: i(({ row: a }) => [w("span", { style: D({ color: (a == null ? void 0 : a.before) !== (a == null ? void 0 : a.after) ? "red" : "" }) }, g(a == null ? void 0 : a.before), 5)]), _: 1 }), c(N, { align: "left", "header-align": "center", label: "变更后", prop: "after" }, { default: i(({ row: a }) => [w("span", { style: D({ color: (a == null ? void 0 : a.after) !== (a == null ? void 0 : a.before) ? "green" : "" }) }, g(a == null ? void 0 : a.after), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[O, B.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = v(se, [["__scopeId", "data-v-d3780987"]]);
export {
  ue as default
};
