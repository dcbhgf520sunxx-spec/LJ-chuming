import { ElMessageBox as i } from "element-plus";
function h({ quantityField: n = "quantity", meteField: t = "mete" }) {
  return { handleOverQuantity: (e, a = false, c = "purchaseQuantity") => {
    e[n] > e[c] && e[n] !== e.originQuantity && (e.mergeId || a) ? i.confirm("本次实收数大于采购数，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      e.originQuantity = e[n];
    }).catch(() => {
      e[n] = e.originQuantity;
    }) : e.originQuantity = e[n];
  }, handleOverMete: (e) => {
    e[t] > e.purchaseMete && e[t] !== e.originMete && e.mergeId ? i.confirm("本次实收量大于采购量，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      e.originMete = e[t];
    }).catch(() => {
      e[t] = e.originMete;
    }) : e.originMete = e[t];
  } };
}
export {
  h as u
};
