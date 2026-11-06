import { ref as n } from "vue";
import { reactive as Je } from "vue";
import { computed as me } from "vue";
import { watch as Xe } from "vue";
import { onMounted as Ze } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as et } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as C } from "vue";
import { createTextVNode as V } from "vue";
import { vShow as T } from "vue";
import { createElementVNode as d } from "vue";
import { createBlock as $ } from "vue";
import { createCommentVNode as z } from "vue";
import { toDisplayString as c } from "vue";
import { unref as y } from "vue";
import { withModifiers as he } from "vue";
import { isRef as tt } from "vue";
import { Fragment as at } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElMessage as J } from "element-plus";
import { ElNotification as fe } from "element-plus";
import { nextTick as lt } from "vue";
import { ElFormItem as ot } from "element-plus";
import { ElCascader as st } from "element-plus";
import { ElDatePicker as it } from "element-plus";
import { ElForm as nt } from "element-plus";
import { ElDescriptionsItem as rt } from "element-plus";
import { ElDescriptions as ut } from "element-plus";
import { ElTableColumn as dt } from "element-plus";
import { ElImage as ct } from "element-plus";
import { ElTooltip as pt } from "element-plus";
import { ElPagination as mt } from "element-plus";
import { _ as ht, qO as B, f9 as ge, J as ft, u as gt, o as yt, qP as bt, az as vt, cb as wt, qQ as _t, cf as ye, oT as be, oS as It, bV as kt, qR as Ct, qw as ve, qS as Tt, er as Nt, qT as Et, qU as Dt, qV as St, qW as Pt, qX as Vt, aj as Lt } from "../../../../../shared/runtime.js";
import { g as xt } from "../../../../../modules/nesting-group-config-c479d3e5.js";
import qt from "./drill-scheduling-dialog.vue.js";
import Ut from "./materials-drawer.vue.js";
import "./binding-detail.vue.js";
const Ot = { class: "head-container" }, Mt = null, Bt = { __name: "preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, materialList: { type: Array, default: () => [] }, thickList: { type: Array, default: () => [] }, thickData: { type: Array, default: () => [] }, type: { type: Number }, padBlockData: { type: Array, default: () => [] }, checkedNodes: { type: Array, default: () => [] }, thick: { type: [Number, String] }, material: { type: [Number, String] } }, emits: ["update:visible", "success", "handleDel", "handleBatchDel"], setup(f, { emit: we }) {
  const D = we, i = f, g = { PRODUCE: { L: "生产工单", K: "NORMAL", V: 1 }, DRILL: { L: "原材料清单", K: "OFFLINE", V: 2 } }, X = n(), b = n(g.PRODUCE.V), W = n([]), F = n([]), Z = n({}), v = Je({ summeryQuantity: 0, summeryWeight: 0, summeryProject: 0 }), ee = n([]), L = n(false), te = n([]), ae = me(() => i.materialList), m = n(false), w = n(), N = n(), E = n(), _ = n([]), le = n(), _e = n(B.NESTING_ISSUED.V), G = n(false), H = n(false), Ie = n([]), I = n(), Q = n(void 0), oe = n([]), R = n(), ke = n([]), S = n(false);
  let x = {};
  const Ce = { productionLineId: [{ required: true, message: "请选择生产班组", trigger: "blur" }], cutConfigId: [{ required: true, message: "请选择切割方式", trigger: "blur" }], askCompleteTime: [{ required: true, message: "请选择排产日期", trigger: "blur" }] }, Te = me(() => {
    var o;
    return { productionLineId: E.value, productClassificationEnum: ge.STEEL_PLATE_PRODUCT.V, material: i.material ? i.material : (o = ae.value[0]) == null ? void 0 : o.name, thick: String(Math.max(...i.list.map((e) => e.thick))), askCompleteTime: w.value, cutConfigId: N.value, saveType: i.type === 0 ? B.UN_NESTING_ISSUED.V : B.NESTING_ISSUED.V };
  }), { handleSizeChange: Ne, handleCurrentChange: Ee, total: De, setTotalPage: Se, queryPage: q } = ft({ fetchHook: Y }), { visible: A, handleClose: U } = gt({ emit: D, props: i, field: "visible", showHook: xe, closeHook: () => {
    b.value = g.PRODUCE.V, x = {};
  } }), { maxHeight: se } = yt({ navbar: false, paginate: true }, A);
  function Y() {
    const o = (q.pageNumber - 1) * q.pageSize, e = o + q.pageSize;
    Se(i.list.length), te.value = i.list.slice(o, e);
  }
  function Pe(o, e) {
    D("handleDel", { row: o, id: e, type: i.type });
  }
  const Ve = () => {
    D("handleBatchDel", { list: W.value, type: i.type });
  };
  function Le(o) {
    var e;
    return o > ((e = i.list[0]) == null ? void 0 : e.askCompleteTime);
  }
  function xe() {
    var o, e;
    w.value = (o = i.list[0]) == null ? void 0 : o.askCompleteTime, E.value = void 0, N.value = void 0, I.value = (e = i.list[0]) == null ? void 0 : e.workshopId, le.value = void 0, je(), Be(), ie(), Y(), _e.value = B.NESTING_ISSUED.V;
  }
  const qe = async (o) => {
    R.value = X.value.getCheckedNodes()[0].pathValues[0];
    try {
      const e = await Ct({ partProdMode: be.SEMI_AUTOMATIC.V, partType: ve.BOARD.V, processType: ye.MAKINGS.V, teamId: o });
      ee.value = e.map((t) => ({ name: t.deviceTypeName, id: t.id }));
    } catch (e) {
      console.log(e);
    }
  };
  function ie() {
    I.value && xt({ workshopId: I.value }).then((o) => {
      oe.value = o.map((e) => (e.name = e.nestingChargePersonName, e));
    });
  }
  function Ue(o) {
    ie();
  }
  function Oe() {
    L.value = false, _.value = [], D("success", { type: 0 }), K.confirm("零件任务已生成，请在零件任务查看", "零件直接排产成功", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false, showCancelButton: false }).then(async () => {
      U(), S.value = false;
    }).catch(() => {
    });
  }
  const Me = (o) => {
    L.value = true, _.value = o.bindingData, x = { projectId: i.list[0].project.id, outboundAddress: Tt.FACTORY.V }, x.list = o.bindingData.map((e) => ({ id: e.id, workshopId: e.workshopId, quantity: e.addNumber, outboundUnit: e.measureUnit, outboundUnitPrecision: e.accountingPrecision, outboundUnitType: e.outboundUnitType }));
  };
  async function Be() {
    try {
      const { content: o } = await bt({ boolNestCutEnum: vt.NESTING.V, issueStatusEnum: wt.IN_NESTING.V });
      o == null || o.forEach((e) => {
        Ie.value.push({ id: e.id, value: e.orderNumber });
      });
    } catch (o) {
      console.log("获取工单失败", o);
    }
  }
  function Re(o) {
    W.value = o;
  }
  const ne = n([]);
  Xe(() => i.list, (o, e) => {
    o.length > e.length && (L.value = false), o.length === 0 && (_.value = [], L.value = false), Ae(i.list), We(i.list), Y(), i.list.forEach((t) => {
      ke.value.push({ length: t.length, machinePartId: t.partId, material: t.material, thick: t.thick, projectId: t.project.id, quantity: t.quantity, serialNumber: t.serialNumber, thumbnail: t.picturePath, weight: t.weight, width: t.width, machinePartNeedId: t.id, productId: t.productId, teamId: t.teamId, taskOrderId: t.orderId, taskNeedMachinePartSchedulingIds: t.taskNeedMachinePartSchedulingIds, boolSendDirectly: t.boolSendDirectly });
    });
  });
  function Ae(o) {
    let e;
    v.summeryProject = 0, v.summeryWeight = 0, v.summeryQuantity = 0, o.forEach((t) => {
      v.summeryQuantity += Number(t.quantity) || 0, v.summeryWeight += Number(t.weight) || 0, t.project.id !== e && (v.summeryProject += 1, e = t.project.id);
    });
  }
  const re = n(false), O = n([]);
  async function je() {
    var o;
    if (!(i.type || re.value)) {
      O.value = [];
      try {
        const e = await _t({ processType: ye.MAKINGS.V, partProdMode: be.SEMI_AUTOMATIC.V, partType: It.SHEET_PART.V });
        O.value = ((o = e.mesBuildingPartCutConfigWorkShopDTOList) == null ? void 0 : o.map((t) => {
          var u;
          return t.name = t.workshopName, t.id = t.workshopId, t.children = ((u = t.mesBuildingPartCutConfigLineDTOList) == null ? void 0 : u.map((p) => {
            var k;
            return p.name = p.productionLineName, p.id = p.productionLineId, p.children = ((k = p.mesBuildingPartCutConfigTeamDTOList) == null ? void 0 : k.map((h) => (h.name = `${h.teamName}${h.deviceTypeName ? "(" + h.deviceTypeName + ")" : ""}`, h))) || [], p;
          })) || [], t;
        })) || [], re.value = true;
      } catch (e) {
        console.log("获取生产组的信息失败", e);
      }
    }
  }
  async function $e() {
    try {
      const { content: o } = await Nt({});
      o.forEach((e) => {
        e.children = e.workshopList;
      }), ne.value = o[0].children;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  Ze(() => $e());
  function ue() {
    S.value && !Mt ? K.confirm("套料任务已下发到套料软件，请在套料软件中查看套料任务", "上传成功", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false, showCancelButton: false }).then(async () => {
      U(), S.value = false;
    }).catch(() => {
    }) : (U(), S.value = false);
  }
  async function ze() {
    if (i.type === 0 && (!E.value || !w.value || !N.value)) return J.warning("必选项不能为空"), false;
    if (i.type === 1 && (!I.value || !w.value)) return J.warning("必选项不能为空"), false;
    const o = [];
    try {
      const e = [];
      if (F.value = [], i.list.forEach((t) => {
        F.value.push(t), o.push({ length: t.length, machinePartId: t.partId, material: t.material, thick: t.thick, projectId: t.project.id, quantity: t.quantity, serialNumber: t.serialNumber, thumbnail: t.picturePath, weight: t.weight, width: t.width, machinePartNeedId: t.id, productId: t.productId, teamId: t.teamId, taskOrderId: t.orderId, workshopId: t.workshopId, id: t.id, orderId: t.orderId, taskNeedMachinePartSchedulingIds: t.taskNeedMachinePartSchedulingIds, boolSendDirectly: t.boolSendDirectly }), e.push({ id: t.partId, quantity: t.quantity });
      }), i.type === 0) K.confirm("是否直接下发排产任务？", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "primary", closeOnClickModal: false }).then(async () => {
        var u;
        m.value = true;
        const t = await Et({ thick: String(Math.max(...i.list.map((p) => p.thick))), cutConfigId: N.value, partList: e });
        if (t != null && t.boolDrillEnum) m.value = false, G.value = true, Z.value = { data: t, outBoundParams: { ...x, workshopId: R.value } };
        else {
          const p = await Dt({ productionLineId: E.value, productClassificationEnum: ge.STEEL_PLATE_PRODUCT.V, material: i.material ? i.material : (u = ae.value[0]) == null ? void 0 : u.name, thick: String(Math.max(...i.list.map((k) => k.thick))), boolOffLine: St.NORMAL.V, schedulingId: le.value, linkList: o, projectId: i.list[0].project.id, askCompleteTime: w.value, cutConfigId: N.value, saveType: B.UN_NESTING_ISSUED.V, batchOutboundDTOParam: { ...x, workshopId: R.value, basicClass: ve.BOARD.V } });
          fe({ title: "零件排产保存成功", type: "success", duration: 2500 }), D("success", { type: 0 }), m.value = false, L.value = false, _.value = [], U();
        }
      }).catch(() => {
        m.value = false, fe({ title: "本次下发作废", type: "info", duration: 2500 }), m.value = false;
      });
      else {
        m.value = true;
        const t = await Pt({ machinePartList: o, completionDate: w.value, workshopId: I.value, projectId: i.list[0].project.id, teamCode: Q.value }), u = t.headers.result && decodeURIComponent(t.headers.result).split(";"), p = u[0].split("=")[1], k = u[1].split("=")[1], h = p === "20000";
        J({ title: `上传${h ? "成功" : "失败"}`, message: h ? "套料排产成功" : `${k}`, type: h ? "success" : "error", duration: 2500 }), Vt(t) && Lt(t), h && (S.value = true, lt(() => {
          ue(), D("success", { type: 1 });
        })), m.value = false;
      }
    } catch (e) {
      m.value = false, console.log("保存零件排产报错", e);
    } finally {
      m.value = false;
    }
  }
  function We(o) {
    const e = [];
    o.forEach((u) => {
      e.includes(`${u.thick}_${u.material}`) || e.push(`${u.thick}_${u.material}`);
    });
    const t = _.value.map((u) => e.includes(u.key) ? u : null);
    _.value = t.filter((u) => u !== null);
  }
  return (o, e) => {
    const t = j("common-button"), u = j("common-select"), p = ot, k = st, h = it, Fe = nt, Ge = rt, He = ut, r = dt, de = j("common-table"), ce = ct, Qe = pt, Ye = mt, Ke = j("common-drawer");
    return M(), et(at, null, [l(Ke, { customClass: "machine-part-scheduling-preview-dlg", title: f.type === 1 ? "零件套料" : "零件排产", modelValue: y(A), "onUpdate:modelValue": e[6] || (e[6] = (a) => tt(A) ? A.value = a : null), size: "80%", "before-close": y(U), showClose: false, closeOnClickModal: false }, { titleAfter: s(() => e[9] || (e[9] = [])), titleRight: s(() => {
      var a;
      return [C(l(t, { onClick: ze, loading: m.value, disabled: !((a = i.list) != null && a.length) || S.value, size: "default", type: "success" }, { default: s(() => e[10] || (e[10] = [V(" 任务下发 ")])), _: 1, __: [10] }, 8, ["loading", "disabled"]), [[T, b.value === g.PRODUCE.V]]), l(t, { onClick: ue, size: "default", type: "info", loading: m.value }, { default: s(() => e[11] || (e[11] = [V(" 关闭 ")])), _: 1, __: [11] }, 8, ["loading"])];
    }), content: s(() => [C(d("div", Ot, [l(Fe, { style: { display: "flex", "flex-wrap": "wrap" }, rules: Ce }, { default: s(() => [f.type ? (M(), $(p, { key: 0, label: "车间:", class: "form-label-require" }, { default: s(() => [l(u, { modelValue: I.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => I.value = a), options: ne.value, "data-structure": { key: "id", label: "name", value: "id" }, style: { width: "200px" }, placeholder: "请选择车间", disabled: m.value, clearable: "", onChange: Ue }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })) : z("", true), f.type ? (M(), $(p, { key: 1, label: "套料团队:", class: "form-label-require" }, { default: s(() => [l(u, { modelValue: Q.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => Q.value = a), options: oe.value, "data-structure": { key: "id", label: "name", value: "id" }, style: { width: "200px" }, placeholder: "请选择套料团队", disabled: m.value || !I.value, clearable: "" }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })) : z("", true), f.type ? z("", true) : (M(), $(p, { key: 2, label: "班组:", class: "form-label-require" }, { default: s(() => [l(k, { ref_key: "cascader", ref: X, modelValue: E.value, "onUpdate:modelValue": e[2] || (e[2] = (a) => E.value = a), options: O.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, separator: " > ", style: { width: "200px" }, filterable: "", class: "filter-item", placeholder: "请选择班组", disabled: m.value, onChange: qe }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })), f.type ? z("", true) : (M(), $(p, { key: 3, label: "切割方式:", class: "form-label-require" }, { default: s(() => [l(u, { modelValue: N.value, "onUpdate:modelValue": e[3] || (e[3] = (a) => N.value = a), options: ee.value, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "选择切割方式", class: "filter-item", disabled: !E.value, style: { width: "200px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })), l(p, { label: "完成日期:", class: "form-label-require" }, { default: s(() => [l(h, { modelValue: w.value, "onUpdate:modelValue": e[4] || (e[4] = (a) => w.value = a), type: "date", size: "default", class: "date-item filter-item", style: { width: "200px" }, placeholder: "选择完成日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", disabled: m.value, "disabled-date": Le }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })], 512), [[T, b.value === g.PRODUCE.V]]), C(l(t, { class: "filter-item", size: "default", type: "primary", plain: "", round: "", style: { "margin-bottom": "10px" } }, { default: s(() => [d("span", null, "项目数：" + c(v.summeryProject), 1), e[12] || (e[12] = V("   |  ")), d("span", null, "零件数量： " + c(v.summeryQuantity), 1), e[13] || (e[13] = V("   |   ")), d("span", null, "零件重量：" + c(y(kt)(v.summeryWeight)) + "kg", 1)]), _: 1, __: [12, 13] }, 512), [[T, b.value === g.PRODUCE.V]]), C(l(t, { type: "danger", icon: "el-icon-delete", size: "default", disabled: !W.value.length, style: { float: "right" }, onClick: Ve }, { default: s(() => e[14] || (e[14] = [V(" 批量删除 ")])), _: 1, __: [14] }, 8, ["disabled"]), [[T, b.value === g.PRODUCE.V]]), C(l(He, { size: "default", border: "", style: { "margin-bottom": "10px" } }, { default: s(() => [l(Ge, { label: "项目：", "label-align": "center", align: "left" }, { default: s(() => {
      var a, P;
      return [V(c(f.list.length ? `${(a = f.list[0].project) == null ? void 0 : a.serialNumber}${(P = f.list[0].project) == null ? void 0 : P.shortName}` : "-"), 1)];
    }), _: 1 })]), _: 1 }, 512), [[T, b.value === g.DRILL.V]]), C(l(de, { data: te.value, "return-source-data": "", "max-height": y(se), style: { width: "100%" }, id: "listTables", onSelectionChange: Re }, { default: s(() => [l(r, { type: "selection", width: "55" }), l(r, { label: "序号", type: "index", align: "center", width: "60" }), l(r, { "show-overflow-tooltip": true, prop: "project", label: "所属项目", "min-width": "200px", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(`${a.project.serialNumber}${a.project.shortName}`), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.serialNumber), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "thick", label: "厚度", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.thick), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.material), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "width", label: "宽度(mm)", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.width), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.length), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "weight", label: "重量(kg)", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.weight || "-"), 1)]), _: 1 }), l(r, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.quantity), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, label: "操作", width: "80", align: "center" }, { default: s(({ row: a }) => [l(t, { type: "danger", disabled: m.value, icon: "el-icon-delete", size: "default", onClick: he((P) => Pe(a, a.id), ["stop"]) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), [[T, b.value === g.PRODUCE.V]]), C(l(de, { data: _.value, "return-source-data": "", "max-height": y(se), style: { width: "100%" }, id: "listTablesTwo" }, { default: s(() => [l(r, { label: "序号", type: "index", align: "center", width: "60" }), l(r, { "show-overflow-tooltip": true, prop: "serialNumber", label: "物料编号", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.serialNumber), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "classifyName", label: "物料种类", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.classifyName), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "thickness", label: "厚度", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.thickness), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "specification", label: "材质", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.specification), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(`${a.length} * ${a.width}`), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "area", label: "单张面积(m²)", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(`${(a.length / 1e3 * (a.width / 1e3)).toFixed(2)}`), 1)]), _: 1 }), l(r, { "show-overflow-tooltip": true, prop: "weight", label: "重量(kg)", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(Math.round(a.addNumber * a.oneWeight / 1e3)), 1)]), _: 1 }), l(r, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.addNumber), 1)]), _: 1 }), l(r, { prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", align: "center" }, { default: s(({ row: a }) => {
      var P, pe;
      return [d("span", null, c(`${((P = a == null ? void 0 : a.project) == null ? void 0 : P.serialNumber) || "-"}${((pe = a == null ? void 0 : a.project) == null ? void 0 : pe.shortName) || "-"}`), 1)];
    }), _: 1 }), l(r, { prop: "warehouse", "show-overflow-tooltip": true, label: "库位", align: "center" }, { default: s(({ row: a }) => [d("span", null, c(a.warehouse.name), 1)]), _: 1 }), l(r, { key: "picturePath", prop: "picturePath", label: "缩略图", align: "center" }, { default: s(({ row: a }) => [l(Qe, { placement: "top", effect: "light", ref: "tooltip", "show-after": 200 }, { content: s(() => [l(ce, { style: { width: "200px", height: "200px" }, fit: "scale-down", "scroll-container": "#listTablesTwo .el-table__body-wrapper", src: `${a.picturePath}` }, null, 8, ["src"])]), default: s(() => [l(ce, { style: { width: "100%", height: "20px" }, lazy: "", fit: "scale-down", "scroll-container": "#listTablesTwo .el-table__body-wrapper", src: `${a.picturePath}` }, null, 8, ["src"])]), _: 2 }, 1536)]), _: 1 }), l(r, { "show-overflow-tooltip": true, label: "操作", width: "80", align: "center" }, { default: s(() => [l(t, { type: "danger", disabled: m.value, icon: "el-icon-delete", size: "default", onClick: e[5] || (e[5] = he((a) => H.value = true, ["stop"])) }, null, 8, ["disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), [[T, b.value === g.DRILL.V]]), C(l(Ye, { total: y(De), "current-page": y(q).pageNumber, "page-size": y(q).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: y(Ne), onCurrentChange: y(Ee) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), [[T, b.value === g.PRODUCE.V]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]), l(qt, { visible: G.value, "onUpdate:visible": e[7] || (e[7] = (a) => G.value = a), queryParams: Te.value, schedulingGroups: O.value, "total-list": F.value, "drill-data": Z.value, onSuccess: Oe }, null, 8, ["visible", "queryParams", "schedulingGroups", "total-list", "drill-data"]), l(Ut, { visible: H.value, "onUpdate:visible": e[8] || (e[8] = (a) => H.value = a), list: f.list, bindingWorkshopId: R.value, sureBinding: _.value, schedulingGroups: O.value, onSuccess: Me }, null, 8, ["visible", "list", "bindingWorkshopId", "sureBinding", "schedulingGroups"])], 64);
  };
} }, Ft = ht(Bt, [["__scopeId", "data-v-71159069"]]);
export {
  Ft as default
};
